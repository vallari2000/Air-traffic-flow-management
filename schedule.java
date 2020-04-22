import java.util.*; 

class flight // this is the class of each flight details
{
	char status; //Arrival or departure
	String city; //city name
	boolean avail;  //Checking availability of slot in the schedule
	int dur; // Duration of flight
	flight() //constructor
	{
		avail=false; //Initializing availability of 
	}
	void accept() // Accept details of the flight
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Arrival/departure:(A/D):");
		status=sc.next().charAt(0);
		System.out.println("City: ");
		city=sc.next();
		System.out.println("Duration: ");
		dur=sc.nextInt();
	}
}
class airport // This class gives the details of a particular airport
{
	flight f[][]=new flight[7][24]; 
	/*
	Above is the double dimensional array of objects of the class flight.
	We have done this to implement the schedule of flights in a week.
	7 days in a week and 24 hours in a day.
	Also, there is an assumption that the plane will depart every one hour from the 	airport.(As mentioned in the ppt)
	*/
	flight temp=new flight();
	int k,flag;
	airport()
	{
		k=0;
		flag=0;
	}
	void getdata()
	{
		//m.temp.accept();
		temp.accept();
	}
	void init()
	{
		for(int j=0;j<7;j++)
		for(int i=0;i<24;i++)
		{	
			f[j][i]=new flight();			
		}
	}
	void assign(airport m)
	{
		while(flag==0)
		{		
		for(int i=0;i<24;i++)
		{
			if(f[k][i].avail==false && m.f[k][i+temp.dur].avail==false)
			{
				
				temp.avail=true;
				
				f[k][i]=temp;
				m.f[k][i+temp.dur]=f[k][i];
				m.f[k][i+temp.dur].status='A';
				flag=1;	
				break;
			}
		}
		if(flag==0)
			k++;
		}
	}
	void display(String c)
	{
		System.out.print("\nDeparture city\tArrival city\tTime of departure\tTime of arrival\n");
		for(int j=0;j<7;j++)
		for(int i=0;i<24;i++)
		{
			if(f[j][i].avail==true)
			{
				System.out.print(c);
				System.out.print("\t\t\t"+f[j][i].city);
				System.out.print("\t\t\t"+i);
				//System.out.print("\t\t"+f[j][i].dur);
				System.out.print("\t \t"+(i+f[j][i].dur));
				System.out.println();
			}
			//System.out.println("City:"+f[j][i].city+"\tAvailable:"+f[j][i].avail);
		}
	}
}
/* Note: The input fields can be replaced by analyzing the data sets and adding values to it atomatically.
*/
public class schedule
{
	public static void main(String[] args)
	{
		
		airport dub=new airport(); //Making object of airport class
		dub.init(); // Allocating memory for the schedule array
		airport delhi=new airport();		
		delhi.init();
		dub.getdata(); // Input data of flights
		dub.assign(delhi);	//Assigning the flights to the schedule

		//Similarly, we have made objects of some of the other cities/airports
		//We have just selected some of the starting cities from the given sample dataset

		airport lon=new airport();
		lon.init();
		lon.getdata();
		lon.assign(delhi);

		airport kath=new airport();
		kath.init();
		kath.getdata();
		kath.assign(delhi);

		airport sing=new airport();
		sing.init();
		sing.getdata();
		sing.assign(delhi);

		airport bang=new airport();
		bang.init();
		bang.getdata();
		bang.assign(delhi);

		airport abu=new airport();
		abu.init();
		abu.getdata();
		abu.assign(delhi);

		airport hong=new airport();
		hong.init();
		hong.getdata();
		hong.assign(delhi);

		airport frank=new airport();
		frank.init();
		frank.getdata();
		frank.assign(delhi);

		//abu.display();		

		delhi.display("Delhi");
	}
}
/*OUTPUT
Arrival/departure:(A/D):
D
City: 
Dubai   
Duration: 
3
Arrival/departure:(A/D):
London
City: 
^C[user@localhost ~]$ javac schedule.java
[user@localhost ~]$ java schedule
Arrival/departure:(A/D):
D
City: 
Dubai
Duration: 
2
Arrival/departure:(A/D):
D
City: 
London
Duration: 
3
Arrival/departure:(A/D):
D
City: 
Kathmandu
Duration: 
4
Arrival/departure:(A/D):
D
City: 
Singapore
Duration: 
2
Arrival/departure:(A/D):
D
City: 
Bangkok
Duration: 
3
Arrival/departure:(A/D):
D
City: 
Abudhabi
Duration: 
1
Arrival/departure:(A/D):
D
City: 
HongKong
Duration: 
2
Arrival/departure:(A/D):
D
City: 
Frankfurt
Duration: 
5

Departure city	Arrival city	Time of departure(hrs)	Time of arrival(hrs)
Delhi		Abudhabi			1	 	2
Delhi		Dubai				2	 	4
Delhi		London				3	 	6
Delhi		Kathmandu			4	 	8
Delhi		Singapore			5	 	7
Delhi		Bangkok				6	 	9
Delhi		HongKong			7	 	9
Delhi		Frankfurt			8	 	13
*/
