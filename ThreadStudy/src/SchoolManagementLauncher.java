import org.zhxu.school.Student;
import org.zhxu.school.Class;
import org.zhxu.network.*;

public class SchoolManagementLauncher
{
    public static void go ()
    {
        System.out.println("School Management System is launched.");

		Student a = new Student("Zhang",10,	"Cheng Du");
		Student b = new Student("Li",	9,	"Chong Qing");
		Student c = new Student("Wang",	12,	"Bei Jing");
		Student d = new Student("Xu",	11,	"Shen Zhen");
		
		org.zhxu.school.Class myClass = new org.zhxu.school.Class();
		myClass.addNewStudent(a);
		myClass.addNewStudent(b);
		myClass.addNewStudent(c);
		myClass.addNewStudent(d);
		
		myClass.printNameList();
		
		myClass.deleteStudent(c);
		
		myClass.printNameList();
		
		return;
    }
}

