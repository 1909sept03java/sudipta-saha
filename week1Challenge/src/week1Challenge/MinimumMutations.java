package week1Challenge;

import java.util.ArrayList;
import java.util.List;

public class MinimumMutations {

	public static void main(String[] args) {
		String start = "AACCGGTT";
		String end =  "AAACGGTA";
		String bank[] = {"AACCGGTA", "AAACGGTT", "AACCGCTA", "AAACGGTA"};
		FindingMinimumMutations findingMinimumMutations = new FindingMinimumMutations();
		System.out.println(findingMinimumMutations.findMutation(start, end, bank));
		//System.out.println(start.equals(end));
	}


}

class FindingMinimumMutations{
	int findMutation(String start, String end, String bank[]) {
		if(!(start.equals(end))) {
			ArrayList<String> mutations = new ArrayList<String>();
			StringBuilder startMutation = new StringBuilder(start);
			int count=0;
			int checker=0;
			//System.out.println(count);
			for(int i = 0; i<8; i++) {
				if(start.charAt(i)!=end.charAt(i)) {
					startMutation.setCharAt(i, end.charAt(i));
					mutations.add(startMutation.toString());
					count++;
				}
			}
			//System.out.println(count);
			//System.out.println(mutations);

			for(int i =0; i<mutations.size(); i++) {
				for(int j = 0; j < bank.length; j++)
					if(mutations.get(i).equals(bank[j])) {
						checker++;
					}
			}
			//System.out.println(checker);
			if(checker==count) {
				return count;
			}

		}
		return 0;
	}

}

