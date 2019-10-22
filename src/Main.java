import javax.swing.JOptionPane;

public class Main
{
    public static void main(String[] args)
    {
        int[] n;
        while (true)
        {
            String[] s = JOptionPane.showInputDialog("Entre com os valores separados por ',' :").split(",");
            try
            {
                n = new int[s.length];
                for (int i = 0; i < n.length ; i++)
                {
                    n[i] = Integer.parseInt(s[i]);
                }
                break;
            } catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "ERROR: NaN (Not a number)", "NaN", JOptionPane.ERROR_MESSAGE);
                continue;
            }
        }
        MergeSort.mergeSort(n, 0, n.length - 1);
        String print = new String();
        for (int i = 0; i < n.length; i++)
        {
            print += n[i];
            if(i != n.length - 1)
                print += ", ";
        }
        JOptionPane.showMessageDialog(null, print);
    }
}
