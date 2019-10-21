public class MergeSort
{
    public static void mergeSort(Integer[] arr, int init, int end)
    {
        // Primeiro a verificação se está na fase minima do array
        if (init < end)
        {
            int midIndex = (init + end) / 2;
            // Isso irá dividir o array do meio pra esquerda
            mergeSort(arr, init, midIndex);
            // Isso irá dividir para direita
            mergeSort(arr, midIndex + 1, end);
            // Se estiver na fase mínima quer dizer que não há mais como dividir
            merge(arr, init, midIndex, end);
        }
    }

    private static void merge(Integer[] arr, int init, int mid, int end)
    {
        // n1 e n2 é basicamente o tamanho dos vetores, o da esquerda e o da direita
        int n1 = mid - init + 1;
        int n2 = end - mid;
        // Criação dos vetores, sendo 1 que estará a esquerda e outro a direita
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Colocando os valores dentro dos vetore
        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[init + i]; // O primeiro valor do vetor da esquerda será o primeiro valor a partir do inicio
        for (int i = 0; i < n2; i++)
            rightArr[i] = arr[mid + i + 1];

        // Variáveis auxiliares, i representando o vetor da esquerda e j o da direita
        int i = 0, j = 0;
        // O k irá representar a posição no próprio vetor
        int k = init;

        while (i < n1 && j < n2)
        {
            // Verificação de qual valor é menor
            if (leftArr[i] <= rightArr[j])
            {
                arr[k] = leftArr[i]; // Colocando o valor direto no vetor original
                i++;
            } else
            {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        // Caso sobre valores, tanto na esquerda, quanto na direita, será posto até terminar
        while (i < n1)
            arr[k++] = leftArr[i++];
        while (j < n2)
            arr[k++] = rightArr[j++];
    }
} 