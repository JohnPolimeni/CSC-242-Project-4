
public class PerceptronClassifier extends LinearClassifier {

	public PerceptronClassifier(int ninputs) {
		super(ninputs);
		// TODO Auto-generated constructor stub
	}

	public PerceptronClassifier(double[] weights) {
		super(weights);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(double[] x, double y, double alpha) {

		
		double globalError = 1;

		int iterator = 0;
		while(iterator < 10 && globalError != 0){
			iterator++;
			for(int p = 0; p < x.length; p++){
				double output = this.eval(x);
				double localError = y - output;

				for(int i = 0; i < this.weights.length; i++){
					this.weights[i] += alpha * localError * x[i];

					globalError += (localError * localError);

				}
			}
		}
	}

	@Override
	public double threshold(double z) {
		if(z >= 0){
			return 1;
		} else {
			return 0;
		}
	}

}