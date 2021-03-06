                                                                                 Java Basic Data Structure Assignment 1 
Question 1: Find out if the given number is an Armstrong number or not.

Sol:
import java.util.Scanner;

class ArmstrongOrNot {
    public boolean armstrongCheck(int num) {
        int sum=0,arm = num;
        while(num>0) {
            int temp = num%10;
            sum = sum + (temp*temp*temp);
            num = num/10;
        };
        if(sum == arm) {
            return true;
        }
        return false;
    }
}

public class Assignment1Q1 {
    public static void main(String[] args) {
    	System.out.println("Enter the number: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArmstrongOrNot check = new ArmstrongOrNot();
        boolean res = check.armstrongCheck(num);
        System.out.println(res);
        sc.close();
    }
}


Question 2: Find out all the Armstrong numbers falling in the range of 100-999

Sol:
import java.util.ArrayList;

class ArmstrongNumBetweenRange{
    public int[] armstrongNumbersInRange(int min , int max){
    	
        boolean x;
        ArrayList<Integer> myValues = new ArrayList<Integer>();
        
        for(int i = min;i<=max; i++){
        	x = armstrongCheck(i);
            if(x == true){
                myValues.add(i);
            }
        }
        
        int[] arr = myValues.stream().mapToInt(i -> i).toArray(); 
		return arr;
	}
	public boolean armstrongCheck(int num) {

		String s = String.valueOf(num);
		int size = s.length();
		int total = 0;
		int myNum = num;

		for (int i = 0; i < size; i++) {
			if (myNum > 0) {
				int temp = myNum % 10;
				total += Math.pow(temp, size);
				myNum = myNum / 10;
			}
		}
		if (num == total) {
			return true;
		} else {
			return false;
		}
	
    }
}

public class Assignment1Q2 {
    public static void main (String [] args) {

       int min = 100;int max = 999;
       
       ArmstrongNumBetweenRange myRange = new ArmstrongNumBetweenRange();
       
       for (int element: myRange.armstrongNumbersInRange(min,max)) {
           System.out.println(element);
       }

    }
}

Question 3:Find out the simple as well as the compound interest of supplied value

Sol:
class SiCi {

    public double simpleInterest(double principalAmount,int time,double interestRate){
    	
    	return (principalAmount*interestRate*time)/100;
    }
    public double compoundInterest(double principalAmount,int time,double interestRate){
    	double p = principalAmount;
    	double r = interestRate/100;
    	int t = time;
    	double interest = (p * Math.pow(1 + (r), t)) - p;

        return interest;
    }
}
public class Assignment1Q3 {
    public static void main (String args[]) {
    	
    	SiCi myInterest = new SiCi();
    	System.out.println(myInterest.simpleInterest(1000,2,10));
    	System.out.println(myInterest.compoundInterest(1000,2,10));
    }
}

Question 4: Supply marks of three subject and declare the result, result declaration is based on below conditions:

              Condition 1: -All subjects marks is greater than 60 is Passed

              Condition 2: -Any two subjects marks are greater than 60 is Promoted

              Condition 3: -Any one subject mark is greater than 60 or all subjects??? marks less than 60 is failed.

Sol:
class ResultDeclaration {
	public String declareResults(double subject1Marks, double subject2Marks, double subject3Marks) {

		if ((subject1Marks + subject2Marks + subject3Marks) > 60) {
			if (subject1Marks > 60 && subject2Marks < 60 && subject2Marks < 60) {
				return "failed";
			} else if (subject1Marks < 60 && subject2Marks > 60 && subject2Marks < 60) {
				return "failed";
			} else if (subject1Marks < 60 && subject2Marks < 60 && subject2Marks > 60) {
				return "failed";
			} else if ((subject1Marks + subject2Marks) > 60 || (subject2Marks + subject3Marks) > 60
					|| (subject3Marks + subject1Marks) > 60) {
				return "passed"
						+ "\n"
						+ "promoted";
			}
		}

		if ((subject1Marks + subject2Marks + subject3Marks) < 60) {
			return "failed";
		}

		if ((subject1Marks + subject2Marks) > 60 || (subject2Marks + subject3Marks) > 60
				|| (subject3Marks + subject1Marks) > 60) {
			return "promoted";
		}
		return "passed";
	}

}

public class Assignment1Q4 {
	public static void main(String[] args) {

		ResultDeclaration result = new ResultDeclaration();
		System.out.println(result.declareResults(10, 30, 40));

	}
}


Question 5:Calculate the income tax on the basis of following table. 

              Note:-Assume slab is consider for Male, Female as well as Senior citizen

                             Slab                                   Income Range                             Tax payable in Percentage

                             Slab A                               0-1,80,000                                                                  Nil

                             Slab B                               1,81,001-3,00,000                                                    10%

                             Slab C                               3,00,001-5,00,000                                                    20%

                             Slab D                               5,00,001-10,00,000                                                 30%     

              Accept CTC from user and display tax amount     

Sol:  
import java.util.Scanner;

class TaxAmount{
    public double calculateTaxAmount(int ctc){
    	double slab = 0;
    	if(ctc<=180000) {
    		slab = 0;  //A
    	}else if(ctc >=180001 && ctc <= 300000){
    		slab = 0.1;  //B
    	}else if(ctc>=300001 && ctc<=500000) {
    		slab = 0.2; //C
    	}else if(ctc>=500001 && ctc<=1000000) {
    		slab = 0.3; //C
    	}
    	
    	double tax = ctc*slab;
    	
    	return tax;
    }
}
public class Assignment1Q5 {
    public static void main(String args[]) {
    	Scanner scan = new Scanner(System.in);
    	int ctc = scan.nextInt();
    	TaxAmount tax = new TaxAmount();
    	System.out.println(tax.calculateTaxAmount(ctc));
    	scan.close();
   }
}

Question 6:Consider a CUI based application, where you are asking a user to enter his Login name and password, after entering the valid user-id and password it will print the message ???Welcome??? along with user name.
 As per the validation is concerned, the program should keep a track of login attempts. After three attempts a message should be flashed saying ???Contact Admin??? and the program should terminate. 

Sol:
import java.util.Scanner;

class Login {
	String userId = "Ajay", password = "password";

	public String loginUser(String user, String pass) {
		if (user.equals(userId) && pass.equals(password)) {
			return "Welcome " + user;
		}
		else {
		return "dummy";
		}
	}
}

public class Assignment1Q6 {
	public static void main(String[] args) {
		int i = 0;
		Login myLogin = new Login();
		Scanner sc = new Scanner(System.in);
		for (i = 0; i < 3; i++) {
			System.out.println("Enter userId");
			String user = sc.nextLine();
			System.out.println("Enter password");
			String pass = sc.nextLine();
			String getReturn = myLogin.loginUser(user, pass);
			String getString = "Welcome " + myLogin.userId;
			if (getReturn.equals(getString)) {
				System.out.println(getReturn);
				break;
			}
			if(i<2) {
			System.out.println("You have entered wrong credentials ,please enter the right credentials.");
		}}
		if(i==3) {
			System.out.println("You have entered wrong credentials 3 times");
			System.out.println("Contact Admin");
		}
		sc.close();
	}
}


Question 7:There is an Array which is of the size 15, which may or may not be sorted. You should write a program to accept a number and search if it in contained in the array

Sol:
class SearchArray {
	public boolean searchArray(int[] arr, int toCheckValue) {
		for (int i = 0; i < arr.length; i++) {
			if (toCheckValue == arr[i]) {
				return true;
			}
		}
		return false;

	}
}

public class Assignment1Q7 {
	public static void main(String[] args) {
		int arr[] = { 5, 12, 14, 6, 78, 19, 1, 23, 26, 35, 37, 7, 52, 86, 47 };
		int valueToCheck = 19;

		SearchArray search = new SearchArray();
		search.searchArray(arr, valueToCheck);
		System.out.println(search.searchArray(arr, valueToCheck));
	}
}

Question 8:Using the below table write method apply sorting using Bubble Sort

Sol:
class BubbleSort {

	public int[] bubbleSort(int arr[]) {
		int arrSize = arr.length;
		int i = 0;
		int j = 1;
		for (int p = 0; p < arrSize; p++) {
			while (j < arrSize) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					i++;
					j++;
				}
				i++;
				j++;

			}
			i=0;
			j=1;
		}
		return arr;

	}

}

public class Assignment1Q8 {
	public static void main(String args[]) {
		int arr[] = { 5, 12, 14, 6, 78, 19, 1, 23, 26, 35, 37, 7, 52, 86, 47 };
		
		BubbleSort sort = new BubbleSort();
		sort.bubbleSort(arr);
		for (int element: sort.bubbleSort(arr)) {
            System.out.println(element);
        }
	}
}

Question 9: Accept the marks of three students for the subject say A, B, C. Find the total scored and the average in all the subjects. Also Find the Total and Average scored by students in each respective Subject.

Sol:
class Student {
    private int subjectA,subjectB,subjectC;
    Student(){
    	
    }
    Student(int a, int b, int c){
    	subjectA = a;
    	subjectB = b;
    	subjectC = c;
    }
    

    public int studentsTotalMarksInAllSubjects(Student[] students) {
    	
    	
    	int stu1 = students[0].subjectA+students[0].subjectB+students[0].subjectC;
    	int stu2 = students[1].subjectA+students[1].subjectB+students[1].subjectC;
    	int stu3 = students[2].subjectA+students[2].subjectB+students[2].subjectC;
    	
		return stu1+stu2+stu3;
		}

    public double studentsAverageMarksInAllSubjects(Student[] students) {
    	int stu1 = students[0].subjectA+students[0].subjectB+students[0].subjectC;
    	int stu2 = students[1].subjectA+students[1].subjectB+students[1].subjectC;
    	int stu3 = students[2].subjectA+students[2].subjectB+students[2].subjectC;
		return (stu1+stu2+stu3)/3;
		}
    public int[] subjectWiseMarks(Student[] students,String subjectName) {
    	
		return null;
		}
    public int subjectATotalByStudents(int[] marks) {
    	int tot = 0;
 	   for(int i=0;i<marks.length;i++) {
 		   tot+=marks[i];
 	   }
 	return tot;
		}
    public int subjectBTotalByStudents(int[] marks) {
    	int tot = 0;
 	   for(int i=0;i<marks.length;i++) {
 		   tot+=marks[i];
 	   }
 	return tot;
		}
    public int subjectCTotalByStudents(int[] marks) {
    	int tot = 0;
 	   for(int i=0;i<marks.length;i++) {
 		   tot+=marks[i];
 	   }
 	return tot;
		}

   public int subjectTotalByStudents(int[] marks) {
	   int tot = 0;
	   for(int i=0;i<marks.length;i++) {
		   tot+=marks[i];
	   }
	return tot;}
   public double subjectAverageByStudents(int[] marks) {
	   int tot = 0;
	   for(int i=0;i<marks.length;i++) {
		   tot+=marks[i];
	   }
	return tot/3;
   }

    public double subjectAAverageByStudents(int[] marks) {
    	int tot = 0;
 	   for(int i=0;i<marks.length;i++) {
 		   tot+=marks[i];
 	   }
 	return tot/3;
 	}
    public double subjectBAverageByStudents(int[] marks) {
    	int tot = 0;
 	   for(int i=0;i<marks.length;i++) {
 		   tot+=marks[i];
 	   }
 	return tot/3;
 	}
    public double subjectCAverageByStudents(int[] marks) {
    	int tot = 0;
 	   for(int i=0;i<marks.length;i++) {
 		   tot+=marks[i];
 	   }
 	return tot/3;
 	}

}


public class Assignment1Q9 {

	public static void main(String[] args) {
		Student stu1 = new Student();
		Student stu2 = new Student();
		Student stu3 = new Student();
		

	}

}






