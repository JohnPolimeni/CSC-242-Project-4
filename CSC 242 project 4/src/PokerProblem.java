
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;



/**
 * The restaurant WillWait example from AIMA Section 18.3.
 * <p>
 * Run and pass dataset filename on cmd-line.
 */
public class PokerProblem extends Problem {
	
	public PokerProblem() {
		super();
		// Input variables
		this.inputs.add(new Variable("suite of card 1", new Domain("1", "2", "3", "4")));
		this.inputs.add(new Variable("rank of card 1", new Domain("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13")));
		this.inputs.add(new Variable("suite of card 2", new Domain("1", "2", "3", "4")));
		this.inputs.add(new Variable("rank of card 2", new Domain("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13")));
		this.inputs.add(new Variable("suite of card 3", new Domain("1", "2", "3", "4")));
		this.inputs.add(new Variable("rank of card 3", new Domain("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13")));
		this.inputs.add(new Variable("suite of card 4", new Domain("1", "2", "3", "4")));
		this.inputs.add(new Variable("rank of card 4", new Domain("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13")));
		this.inputs.add(new Variable("suite of card 5", new Domain("1", "2", "3", "4")));
		this.inputs.add(new Variable("rank of card 5", new Domain("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13")));
		
		// Output variable
		
		this.output =new Variable("class", new Domain("1", "2", "3", "4", "5", "6", "7", "8", "9"));
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		

		ArrayList<Long> times = new ArrayList<Long>();


		for(int i = 0; i < 1; i++){

			long startTime = System.currentTimeMillis();

			
			Problem problem = new PokerProblem();
			problem.dump();
			Set<Example> examples = problem.readExamplesFromCSVFile(new File("C:\\Users\\johnn\\eclipse-workspace\\CSC 242 project 4\\src\\poker-hand-testing.data.txt"));
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
			Long avg = sum ;
			System.out.println("\naverage time: " + avg);
	
	}

}