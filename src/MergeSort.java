public class MergeSort
{
    public static void mergeSort(int[] vet, int init, int end)
    {
        if (init < end) // Verifica se o array não está em sua forma minima
        {
            int mid = (init + end) / 2;
            // Primeiro irá ir até o minimo
            mergeSort(vet, init, mid);
            mergeSort(vet, mid + 1, end);
            merge(vet, init, mid, end);
        }
    }

    private static void merge(int[] vet, int init, int mid, int end)
    {
        int[] leftArr = formArray(vet, mid - init + 1, init); // Chama método pra formar o array da esquerda
        int[] rightArr = formArray(vet, end - mid, mid + 1); // Chama método pra formar array da direita

        // Variáveis auxiliares
        int i = 0, j = 0, k = init;

        while (true)
        {
            // Método que verifica onde irá colocar o número
            boolean b = whereToGo(i, j, leftArr.length, leftArr[i], rightArr.length, rightArr[j]);

            // No caso se sair verdadeiro vai ser adicionado do array da esquerda o próximo número
            if (b)
                vet[k++] = leftArr[i++];
            else
                vet[k++] = rightArr[j++];

            // Se os dois arrays já não tiverem mais pra onde "correr" o loop e quebrado
            if (i >= leftArr.length && j >= rightArr.length)
                break;
        }
    }

    // Método que forma os arrays
    private static int[] formArray(int[] vet, int length, int whereToStart)
    {
        // O tamanho foi fornecido previamente
        int[] n = new int[length];
        // Vai sendo colocado os números dependendo de onde deve se começar (fornecido previamente)
        for (int i = 0; i < n.length; i++)
            n[i] = vet[i + whereToStart];

        return n;
    }

    // Método que irá verificar onde deve ir o número
    private static boolean whereToGo(int i, int j, int leftLength, int leftNum, int rightNum, int rightLength)
    {
        boolean b;
        // Primeiro verifica se não foi ultrapassado o tamanho do array
        if (i < leftLength && j < rightLength)
            b = leftNum <= rightNum ? true : false; // Para então verificar qual número é o maior
         else // Casojá tenha completado um dos lados, só falta preencher o outro
            b = j >= rightLength ? true: false;
        return b;
    }
}
