package controller;

import java.io.IOException;
import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import data.EventDAO;
import model.Event;
import model.User;
import model.EventErrorMsgs;

/**
 * Servlet implementation class EventController
 */
@WebServlet("/eventController")
public class eventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eventController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        String action = request.getParameter("action"), url ="";
        String EventID = request.getParameter("eventID");
		if(action.equalsIgnoreCase("viewSpecificEvent"))
        {
        	System.out.println(EventID);
        	
        	Event event = new Event();
        	event = EventDAO.getSpecificEvent(request.getParameter("id"));
        	session.setAttribute("eventsummary", event);
            url  ="/viewevent.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
		else
			doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		//String currentTime = new SimpleDateFormat("YYYY-MM-DD").format(Calendar.getInstance().getTime());
		HttpSession session = request.getSession();	
		Event event = new Event();

		String url = "/EventBook.jsp";
		if (action.equalsIgnoreCase("BookEvent") ) {  
			User user = (User)session.getAttribute("currentUser");
			EventErrorMsgs EerrorMsgs = new EventErrorMsgs();
			
			//String HallName = request.getParameter("hallName");
			//String FoodType = request.getParameter("foodType");
			String MealFormality = request.getParameter("mealFormality");
			String DrinkType = request.getParameter("drinkType");
			String EntertainmentItems = request.getParameter("entertainmentItems");
			String Meal = request.getParameter("meal");
			double FoodMealCost = 0;
			double MealFormalityCost = 0 ;
			double DrinkCost = 0;
			//double EntertainmentCost = 0;
			double FinalDepositCost = 0;
			String estAttendees = request.getParameter("estAttendees");
			if(!estAttendees.isEmpty()) {
				
			
			
			/*Food meal type: breakfast, lunch, supper. Meal cost: breakfast $8/person attending, 
			lunch $12/person attending, and supper $18/person attending.*/
			if(Meal.equals("Breakfast")) {	
				FoodMealCost = Integer.parseInt(estAttendees)* 8;
			}else if(Meal.equals("Lunch")) {
				FoodMealCost = Integer.parseInt(estAttendees)* 12;
			}
			else if(Meal.equals("Supper")) {
				FoodMealCost = Integer.parseInt(estAttendees)* 18;
			}
			
			//Formal is 1.5 times the cost of the meal 
			if(MealFormality.equals("Formal")) {
				FoodMealCost = 1.5 * FoodMealCost;
			}
			//Alcohol is $15/person attending.
			if(DrinkType.equals("Alcohol")) {
				DrinkCost = Integer.parseInt(estAttendees)* 15;
			}
			
			
			if(EntertainmentItems.equals("Music")) {
				FinalDepositCost = FoodMealCost + MealFormalityCost + DrinkCost + 50;
			}
			else {
				FinalDepositCost = FoodMealCost + MealFormalityCost + DrinkCost;
			}
			}
			session.setAttribute("DepositValue", FinalDepositCost);
			
			event.setEvent(session.getAttribute("fname").toString(),session.getAttribute("lname").toString()
					,session.getAttribute("date").toString(),session.getAttribute("time").toString(),
					request.getParameter("duration"),request.getParameter("hallName"), 
					request.getParameter("estAttendees"),request.getParameter("eventName"),
					request.getParameter("foodType"),request.getParameter("meal"),
					request.getParameter("mealFormality"),request.getParameter("drinkType"),
					request.getParameter("entertainmentItems"),"Pending","","N/A","N/A","N/A",user.getUsername(),
					String.valueOf(FinalDepositCost));//UserErrorMsgs UerrorMsgs = new UserErrorMsgs();
			
			session.setAttribute("EVENT",event);
			event.validateEvent(event, EerrorMsgs);
			event.validateduration(session.getAttribute("date").toString(),
					session.getAttribute("time").toString(),
					request.getParameter("duration"),EerrorMsgs);
			session.setAttribute("errorMsgs",EerrorMsgs);
			session.setAttribute("EVENT", event);
			if (EerrorMsgs.getErrorMsg().equals("")) {
				EventDAO.registerEvent(event);
				session.removeAttribute("errorMsgs");
				url = "/PayDeposit.jsp";
			}
		}
		else if(action.equalsIgnoreCase("payDeposit"))
        {
			EventErrorMsgs CarderrorMsgs = new EventErrorMsgs();
        	//Event event1 = new Event();	
        	event = (Event) session.getAttribute("EVENT");
        	String ccnumber = request.getParameter("idccNum");
        	String ccseccode = request.getParameter("idinvalidpin");
        	String expdate = request.getParameter("idexpDate");
        	event.setccnumber(ccnumber);
        	event.setccpin(ccseccode);
        	event.setccexpdate(expdate);
			try {
				event.validateCardinfo(event, CarderrorMsgs);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	session.setAttribute("CardErrors", CarderrorMsgs);
        	//String depositAmount = session.getAttribute("DepositValue").toString();
        	if (CarderrorMsgs.getErrorMsg().equals("")) 
        	{
        	EventDAO.UpdateRequest(event.getuserid(), event.getdate(), event.getstartTime(), event.gethallName(), 
        	ccnumber, ccseccode, expdate,"0");
        	url = "/PayDeposit.jsp";
        	session.removeAttribute("DepositValue");
        	}
        	url = "/PayDeposit.jsp";
        }
		else if(action.equalsIgnoreCase("eventsummary")) {
			System.out.print("printttt");
	
			ArrayList<Event> eventlist = EventDAO.getEventSummary();     
			session.setAttribute("Event", eventlist);		
			
			url="/eventsummary.jsp";
						
			
		}
		else if(action.equalsIgnoreCase("goassignStaff")) {
			url="/assignstaff.jsp";
			String temp = request.getParameter("id");
			System.out.println(temp);
			session.setAttribute("eid", request.getParameter("id"));
		}
		else if(action.equalsIgnoreCase("assignStaff")) {
			System.out.print("In assign staff");
			event.seteventID((String)session.getAttribute("eid"));
			String id = session.getAttribute("eid").toString();
			System.out.println(id);
			EventErrorMsgs EerrorMsgs = new EventErrorMsgs();
			session.setAttribute("errorMsgs", EerrorMsgs);
			EerrorMsgs.setStaffError(User.validateStaff(request.getParameter("firstname"), request.getParameter("lastname")));
			EerrorMsgs.setErrorMsg();
			if(EerrorMsgs.getErrorMsg().equals("")) {
				event.setStaff_fname(request.getParameter("firstname"));
				event.setStaff_lname(request.getParameter("lastname"));
				EventDAO.Modifyevent(event);
				url="/eventsummary.jsp";
			}
			else {
				url="/assignstaff.jsp";
			}
			
		}
		else if (action.equalsIgnoreCase("EventDetails")) {
		Event eventInDB2 = new Event();
		System.out.println("ID "+request.getParameter("id"));
		session.setAttribute("eid1", request.getParameter("id"));
		eventInDB2 = EventDAO.getSpecificEvent(session.getAttribute("eid1").toString());
		session.setAttribute("EVENTS", eventInDB2);
		url="/EventDetails.jsp";					
		}
		else
		if (action.equalsIgnoreCase("getDate")) {
			System.out.println("Hello");
			String date = (String) request.getParameter("iddate");
			String time = (String) request.getParameter("idtime");
			session.setAttribute("Date", date);
			session.setAttribute("Time", time);
			url="/eventController?action=ViewAssignedEvents&id1="+date+"&id2="+time;
		}
		else
		if (action.equalsIgnoreCase("ViewAssignedEvents")) {
			ArrayList<Event> eventInDB = new ArrayList<Event>();
			String date = (String) session.getAttribute("Date");
			String time = (String) session.getAttribute("Time");
			eventInDB=EventDAO.listEvents1(date,time);
			session.setAttribute("EVENTS", eventInDB);				
			url="/ViewAssignedEvents.jsp";
		}


		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	

}
