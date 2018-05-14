
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;



public class VotingRecordsProblem extends Problem{
	public VotingRecordsProblem() {
		super();
		// Input variables
		Domain yesNoDomain = new YesNoDomain();
		this.inputs.add(new Variable("Party", new Domain("democrat","republican")));
		for(int i = 0; i < 15; i++ ){
			this.inputs.add(new Variable("some" + i,new Domain("y","n","?")));
		}

		
		
		// Output variable
		this.output = new Variable("Export-Adminstration-Act-South-Africa", new Domain("y","n","?"));
	}
	
	public static void main(String[] args) throws IOException {
		

		ArrayList<Long> times = new ArrayList<Long>();


		for(int i = 0; i < 100; i++){

			long startTime = System.currentTimeMillis();

			Problem problem = new VotingRecordsProblem();
			problem.dump();
			Set<Example> examples = problem.readExamplesFromCSVFile(new File("C:\\Users\\johnn\\eclipse-workspace\\CSC 242 project 4\\src\\house-votes84.data.txt"));
//			for (Example e : examples) {
//				System.out.println(e.inputValues);
//			
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