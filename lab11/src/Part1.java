import java.util.Iterator;

public class Part1 {
	public static void main(String[] args) {
		try {
			ProgramOfStudy program = ProgramOfStudy.load("ProgramOfStudy");
			
			Iterator<Course> iter = program.iterator();
			
			System.out.println("All courses:");
			
			// Print all courses.
			while (iter.hasNext()) {
				System.out.println(iter.next().toString());
			}
			
			System.out.println();
			
			// Reset our iterator.
			iter = program.iterator();
			
			while (iter.hasNext()) {
				Course course = iter.next();
				
				if (course.getGrade().equals("")) {
					iter.remove();
				}
			}
			
			// Reset our iterator.
			iter = program.iterator();

			System.out.println("Courses with grades:");
			
			while (iter.hasNext()) {
				System.out.println(iter.next().toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
