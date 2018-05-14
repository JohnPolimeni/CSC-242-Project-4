
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;


/**
 * The restaurant WillWait example from AIMA Section 18.3.
 * <p>
 * Run and pass dataset filename on cmd-line.
 */
public class WillWaitProblem extends Problem {
	
	public WillWaitProblem() {
		super();
		// Input variables
		Domain yesNoDomain = new YesNoDomain();
		this.inputs.add(new Variable("Alternate", yesNoDomain));
		this.inputs.add(new Variable("Bar", yesNoDomain));
		this.inputs.add(new Variable("Fri/Sat", yesNoDomain));
		this.inputs.add(new Variable("Hungry", yesNoDomain));
		this.inputs.add(new Variable("Patrons", new Domain("None", "Some", "Full")));
		this.inputs.add(new Variable("Price",  new Domain("$", "$$", "$$$")));
		this.inputs.add(new Variable("Raining", yesNoDomain));
		this.inputs.add(new Variable("Reservation", yesNoDomain));
		this.inputs.add(new Variable("Type",  new Domain("French", "Italian", "Thai", "Burger")));
		this.inputs.add(new Variable("WaitEstimate",  new Domain("0-10", "10-30", "30-60", ">60")));
		// Output variable
		this.output = new Variable("WillWait", yesNoDomain);
	}
	
	public static void main(String[] args) throws IOException {
		ArrayList<Long> times = new ArrayList<Long>();

		for(int i = 0; i < 100; i++){
		long startTime=System.currentTimeMillis();
			Problem problem = new WillWaitProblem();
		problem.dump();  
		Set<Example> examples = problem.readExamplesFromCSVFile(new File("C:\\Users\\johnn\\eclipse-workspace\\CSC 242 project 4\\src\\WillWait-data.txt"));
		for (Example e : examples) {
			System.out.println(e);
		}
		DecisionTree tree = new DecisionTreeLearner(problem).learn(examples);
		tree.dump();

		tree.test(examples);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;

		times.add(new Long(totalTime));
	
	}
	
	Long sum = new Long(0);
	for(Long l : times){
		sum += l;
	}
	Long avg = sum / 100;
	System.out.println("\naverage time: " + avg);

	

}
}