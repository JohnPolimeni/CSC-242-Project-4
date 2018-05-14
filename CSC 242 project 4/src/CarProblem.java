
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;


/**
 * The restaurant WillWait example from AIMA Section 18.3.
 * <p>
 * Run and pass dataset filename on cmd-line.
 */
public class CarProblem extends Problem {

	public CarProblem() {
		super();
		// Input variables
		this.inputs.add(new Variable("buying", new Domain("vhigh", "high", "med", "low")));
		this.inputs.add(new Variable("maint", new Domain("vhigh", "high", "med", "low")));
		this.inputs.add(new Variable("doors", new Domain("2", "3", "4", "5more")));
		this.inputs.add(new Variable("persons", new Domain("2", "4", "more")));
		this.inputs.add(new Variable("lug_boot", new Domain("small", "med", "big")));
		this.inputs.add(new Variable("safety", new Domain("low", "med", "high")));

		// Output variable
		this.output =new Variable("class", new Domain("unacc", "acc", "good", "vgood"));
	}

	public static void main(String[] args) throws IOException {

		ArrayList<Long> times = new ArrayList<Long>();


		for(int i = 0; i < 100; i++){

			long startTime = System.currentTimeMillis();

			Problem problem = new CarProblem();
			problem.dump();
			Set<Example> examples = problem.readExamplesFromCSVFile(new File("C:\\Users\\johnn\\eclipse-workspace\\CSC 242 project 4\\src\\car.data.txt"));
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