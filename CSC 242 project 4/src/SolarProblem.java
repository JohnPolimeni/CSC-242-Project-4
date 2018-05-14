
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;


/**
 * The restaurant WillWait example from AIMA Section 18.3.
 * <p>
 * Run and pass dataset filename on cmd-line.
 */
public class SolarProblem extends Problem {

	public SolarProblem() {
		super();
		// Input variables
			this.inputs.add(new Variable("class", new Domain("A", "B", "C", "D", "E", "F", "H")));
			this.inputs.add(new Variable("spot", new Domain("X", "R", "S", "A", "H", "K")));
			this.inputs.add(new Variable("sdist", new Domain("X", "O", "I", "C")));
			this.inputs.add(new Variable("actiivty", new Domain("1", "2")));
			this.inputs.add(new Variable("evolution", new Domain("1", "2", "3")));
			this.inputs.add(new Variable("flare activity", new Domain("1", "2", "3")));
			this.inputs.add(new Variable("history", new Domain("1", "2")));
			this.inputs.add(new Variable("historrry", new Domain("1", "2")));
			this.inputs.add(new Variable("area", new Domain("1", "2")));
			this.inputs.add(new Variable("largespot", new Domain("1", "2")));
			this.inputs.add(new Variable("C-class", new Domain("0", "1", "2", "3", "4", "5", "6", "7", "8" ,"9")));
			this.inputs.add(new Variable("M-class", new Domain("0", "1", "2", "3", "4", "5", "6", "7", "8" ,"9")));
			
			
			
			
		// Output variable
		
	
		this.output =new Variable("X class", new Domain("0", "1", "2", "3", "4", "5", "6", "7", "8" ,"9"));
	}

	public static void main(String[] args) throws IOException {
		ArrayList<Long> times = new ArrayList<Long>();
		for(int i = 0; i < 100; i++){
			long startTime = System.currentTimeMillis();

			
		Problem problem = new SolarProblem();
		problem.dump();
		Set<Example> examples = problem.readExamplesFromFile(new File("C:\\Users\\johnn\\eclipse-workspace\\CSC 242 project 4\\src\\flare.data2.txt"));
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