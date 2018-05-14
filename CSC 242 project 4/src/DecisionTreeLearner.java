
import java.util.List;
import java.util.Set;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DecisionTreeLearner extends AbstractDecisionTreeLearner{

	public DecisionTreeLearner(Problem problem) {
		super(problem);
	}

	/*
	 *Decision Tree Learning method form AIMA figure 18.5
	 */
	protected DecisionTree learn(Set<Example> examples, List<Variable> attributes, Set<Example> parent_examples) {
		if(examples.isEmpty()){
			return new DecisionTree(pluralityValue(parent_examples));
		//might be ' != "" ' instead of ' != null '
		} else if(uniqueOutputValue(examples) != null){
			return new DecisionTree(uniqueOutputValue(examples));
		} else if (attributes.isEmpty()){
			return new DecisionTree(pluralityValue(examples));
		} else {
			//System.out.println("att "  + attributes.toString());
			//System.out.println("examples " + examples.size());
			Variable A = super.mostImportantVariable(attributes, examples);
			DecisionTree tree = new DecisionTree(A);
			for(String vk : A.domain){
				
				//System.out.println(vk + A.domain);
				
				//list of e's such that e is in examples and e.A = vk
				//exs <- {e : e is in examples AND e.A = vk
				Set<Example> exs = new ArraySet<Example>();
				for(Example e : examples){
					if(e.inputValues.get(A).equals(vk)){
						exs.add(e);
					}
				}
				
				List<Variable> attributesMinusA = new ArrayList<Variable>(attributes);
				attributesMinusA.remove(A);
				
				DecisionTree subtree = learn(exs, attributesMinusA, examples);
//				System.out.println("test value  " + subtree.value);
//				System.out.println("test variable " + subtree.variable);
//				subtree.variable = new Variable(A.name, A.domain);
//				subtree.value = vk;
				
//				subtree.variable.name = vk;
//				subtree.variable.domain = A.domain;
				
				tree.children.add(subtree);
				
				
			}
			
			return tree;
		}
	}

	@Override
	protected String pluralityValue(Set<Example> examples){
		HashMap<String, Integer> a = new HashMap<String, Integer>();
		
		//just in case Integer starts at null insetad of 0
		for(Example s : examples){
			a.put(s.outputValue, 0);
		}
		
		//find all the output values in the examples
		for(Example s : examples){
			a.put(s.outputValue, new Integer(1 + a.get(s.outputValue)));
		}
		
		//set curr best to first value
		String currBest = examples.iterator().next().outputValue;
		for(String s : a.keySet()){
			if(a.get(s) > a.get(currBest)){
				currBest = s;
			}
		}
		
		return currBest;
	}

	protected String pluralityValue_VOIDED(Set<Example> examples) {
		int countYes = 0;
		int countNo = 0;
		
		for(Example e : examples){
			if(e.outputValue.equalsIgnoreCase("yes")){
				countYes ++;
			}
			else{
				countNo ++;
			}
		}
		if(Math.max(countYes, countNo) == countYes){
			return "yes";
		}else
			return "no";
		
		
		
		
	}

	@Override
	protected String uniqueOutputValue(Set<Example> examples) {
		String o = examples.iterator().next().outputValue;
		Iterator<Example> i = examples.iterator();
		while(i.hasNext()){
			if(i.next().outputValue.equals(o) == false){
				return null;
			}
		}
		return o;
		
	}

	@Override
	protected Set<Example> examplesWithValueForAttribute(Set<Example> examples, Variable a, String vk) {
		ArraySet<Example> returnSet = new ArraySet<Example>();
		for(Example e : examples){
			if(e.inputValues.get(a).equals(vk)){
				returnSet.add(e);
			}
		}
		return returnSet;
		
		
	}

	@Override
	protected int countExamplesWithValueForAttribute(Set<Example> examples, Variable a, String vk) {
		int count = 0;
		for(Example e : examples){
			if(e.inputValues.get(a).equals(vk)){
				count++;
			}
		}
		return count;
		
	}

	@Override
	protected int countExamplesWithValueForOutput(Set<Example> examples, String vk) {

		int count = 0;
		for(Example e : examples){
			if(e.outputValue.equals(vk)){
				count++;
			}
		}
		
		return count;
	}

}