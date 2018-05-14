
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;


/**
 * The restaurant WillWait example from AIMA Section 18.3.
 * <p>
 * Run and pass dataset filename on cmd-line.
 */
public class TTTProblem extends Problem {

	public TTTProblem() {
		super();
		// Input variables
		for(int i = 0; i < 9; i++){
			this.inputs.add(new Variable("some" + i, new Domain("x", "o", "b")));
		}
		
		
		// Output variable
		
	
		this.output =new Variable("class", new Domain("positive", "negative"));
	}

	public static void main(String[] args) throws IOException {
		ArrayList<Long> times = new ArrayList<Long>();
		for(int i = 0; i < 100; i++){
			long startTime = System.currentTimeMillis();

		
		Problem problem = new TTTProblem();
		problem.dump();
		Set<Example> examples = problem.readExamplesFromCSVFile(new File("C:\\Users\\johnn\\eclipse-workspace\\CSC 242 project 4\\src\\ttt.data.txt"));
		for (Example e : examples) {
			System.out.println(e);
		}
		DecisionTree tree = new DecisionTreeLearner(problem).learn(examples);
		tree.dump();
		tree.test(problem.readExamplesFromCSVFile(new File("C:\\Users\\johnn\\eclipse-workspace\\CSC 242 project 4\\src\\ttt.data.txt")));
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