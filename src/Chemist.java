import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by NamjinCho on 2017-07-04.
 */
public class Chemist {

    static String[] symbols = {"H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg", "Al",
            "Si", "P", "S", "Cl", "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe",
            "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr", "Rb", "Sr",
            "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb",
            "Te", "I", "Xe", "Cs", "Ba", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au",
            "Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn", "Fr", "Ra", "Rf", "Db", "Sg",
            "Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Fl", "Lv", "La", "Ce", "Pr", "Nd",
            "Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb", "Lu", "Ac",
            "Th", "Pa", "U", "Np", "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md",
            "No", "Lr"};


    static String Answer;
    static HashMap<String, Boolean> maps;

    public static void main(String args[]) throws Exception {
        /*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));

        int T = sc.nextInt();

        for (int i = 0; i < symbols.length; i++)
            symbols[i] = symbols[i].toLowerCase();

        Arrays.sort(symbols);

        String dump = sc.nextLine();
        for (int test_case = 0; test_case < T; test_case++) {

            // Answer = 0;
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////
            String str = sc.nextLine();

            boolean[] result = new boolean[str.length()];

            for(int i=0;i<str.length();i++){
                String s1 = str.substring(i, i+1);
                if( i == 0 ){
                    result[i] = (Arrays.binarySearch(symbols,s1)>=0);
                }else{
                    String s2 = str.substring(i-1, i+1);
                    if( i == 1 ){
                        result[i] = ( result[i-1] && (Arrays.binarySearch(symbols,s1)>=0) ) || (Arrays.binarySearch(symbols,s2)>=0);
                    }else{
                        result[i] = ( result[i-1] && (Arrays.binarySearch(symbols,s1)>=0) ) || ( result[i-2] && (Arrays.binarySearch(symbols,s2)>=0) );
                    }
                }
            }

            if (result[str.length()-1])
                Answer = "YES";
            else
                Answer = "NO";
            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.println(Answer);

        }
    }
}
