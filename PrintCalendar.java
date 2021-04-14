
package printcalendar;
import java.util.Scanner;
public class PrintCalendar {

   
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter full year (e.g, 2012): ");
        int year = input.nextInt();
//        System.out.print("Enter month as a number between 1 to 12: ");
//        int month = input.nextInt();
        for(int j = year-1;j<=year+1;j++)
            for(int i = 1;i <= 12; i++)
                PrintMonth(j,i);
        
    }
    
    public static void PrintMonth(int year,int month)
    {
        PrintMonthTittle(year,month); // Print the heading of the calender
        PrintMonthBody(year,month);
    }
    public static void PrintMonthTittle(int year,int month)
    {
        System.out.println("       " + GetMonthName(month) + " " + year);
        System.out.println("-------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat ");
    }
    public static String GetMonthName(int month)
    {
        String monthname = "";
        switch(month)
        {
            case  1: monthname = "January";break;
            case  2: monthname = "February";break;
            case  3: monthname = "March";break;
            case  4: monthname = "April";break;
            case  5: monthname = "May";break;
            case  6: monthname = "June";break;
            case  7: monthname = "July";break;
            case  8: monthname = "August";break;
            case  9: monthname = "September";break;
            case 10: monthname = "October";break;
            case 11: monthname = "November";break;
            case 12: monthname = "December";break;
        }
        return monthname;
    }
    
    public static void PrintMonthBody(int year,int month)
    {
        int startday = getStartDay(year,month);
        int numberofdaysofMonth = GetnumberofDaysinMonth(year,month);
        for(int i = 0; i< startday ; i++)
            System.out.print("    ");
        for(int i = 1;i <= numberofdaysofMonth; i++)
        {
            System.out.printf("%4d", i);
            if(( i + startday ) % 7 == 0)
                System.out.println();
        }
        System.out.println();
        System.out.println();
    }
    public static int getStartDay(int year,int month)
    {
        final int START_DAY_FOR_JAN_1_1800 = 3;
        int totalnumberofdays = getTotalNumberofDays(year,month);
        return (totalnumberofdays + START_DAY_FOR_JAN_1_1800 ) % 7;
    }
    public static int getTotalNumberofDays(int year,int month)
    {
        int total = 0;
        for(int i=1800;i<year;i++) // Day count from 1800 to year-1
        {
            if(IsLeapYear(i))
                total+=366;
            else
                total+=365;
        }
        for(int i = 1;i<month;i++)
        {
            total+=GetnumberofDaysinMonth(year,i);
        }
        return total;
    }
    public static int GetnumberofDaysinMonth(int year,int month)
    {
        int day = 0;
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            day = 31;
        else if(month == 4 || month == 6 || month == 9 || month == 11)
            day = 30;
        else if(month == 2)
        {
            if(IsLeapYear(year))
                day = 29;
            else
                day = 28;
        }
        return day;
    }
    public static boolean IsLeapYear(int year)
    {
        return (year%400 == 0 || (year%4 == 0 && year%100 != 0));
            
    }
}
