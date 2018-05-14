
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;


/**
 * The restaurant WillWait example from AIMA Section 18.3.
 * <p>
 * Run and pass dataset filename on cmd-line.
 */
public class IrisProblem extends Problem {
	
	public IrisProblem() {
		super();
		// Input variables
		this.inputs.add(new Variable("sepal length", new Domain("S", "MS", "ML", "L")));
		this.inputs.add(new Variable("sepal width", new Domain("S", "MS", "ML", "L")));
		this.inputs.add(new Variable("petal length", new Domain("S", "MS", "ML", "L")));
		this.inputs.add(new Variable("petal width", new Domain("S", "MS", "ML", "L")));
		//this.inputs.add(new Variable("class", new Domain("Iris Setosa", "Iris Versicolour", "Iris Virginica")));
		// Output variable
		
		this.output =new Variable("class", new Domain("Iris Setosa", "Iris Versicolour", "Iris Virginica"));
	}
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<Long> times = new ArrayList<Long>();
		

		for(int i = 0; i < 100; i++){

			long startTime = System.currentTimeMillis();
			
			
			Problem problem = new IrisProblem();
			problem.dump();
			Set<Example> examples = problem.readExamplesFromCSVFile(new File("C:\\Users\\johnn\\eclipse-workspace\\CSC 242 project 4\\src\\iris.data.txt"));
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