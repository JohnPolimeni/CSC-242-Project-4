
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

//import dt.core.DecisionTree;
//import dt.core.DecisionTreeLearner;
//import dt.core.Domain;
//import dt.core.Example;
//import dt.core.Problem;
//import dt.core.Variable;
//import dt.core.YesNoDomain;

/**
 * The restaurant WillWait example from AIMA Section 18.3.
 * <p>
 * Run and pass dataset filename on cmd-line.
 */
public class AdultStretchBalloon extends Problem {

	public AdultStretchBalloon() {
		super();
		// Input variables
		this.inputs.add(new Variable("color", new Domain("YELLOW", "PURPLE")));
		this.inputs.add(new Variable("size", new Domain("LARGE", "SMALL")));
		this.inputs.add(new Variable("stret", new Domain("STRETCH", "DIP")));
		this.inputs.add(new Variable("AGE", new Domain("ADULT", "CHILD")));

		// Output variable


		this.output =new Variable("class", new Domain("T", "F"));
	}

	public static void main(String[] args) throws IOException {

		
		ArrayList<Long> times = new ArrayList<Long>();
	

		for(int i = 0; i < 100; i++){

			long startTime = System.currentTimeMillis();
			
			
			Problem problem = new AdultStretchBalloon();
			problem.dump();
			Set<Example> examples = problem.readExamplesFromCSVFile(new File("C:\\Users\\johnn\\eclipse-workspace\\CSC 242 project 4\\src\\adult+stretch.data.txt"));
//			for (Example e : examples) {
//				System.out.println(e);
//			}
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