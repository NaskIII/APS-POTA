class Sort(object):
    def bubbleSort(self, array):
        for i in range(1, len(array) + 1):
            for j in range(len(array) - i):
                if array[j] > array[j + 1]:
                    array[j], array[j + 1] = array[j + 1], array[j]

    def selectionSort(self, array):
        for i in range(len(array)):

            min_idx = i
            for j in range(i + 1, len(array)):
                if array[min_idx] > array[j]:
                    min_idx = j

            array[i], array[min_idx] = array[min_idx], array[i]

    def insertionSort(self, alist):
        for i in range(1, len(alist)):
            temp = alist[i]
            j = i - 1
            while j >= 0 and temp < alist[j]:
                alist[j + 1] = alist[j]
                j = j - 1
            alist[j + 1] = temp

    def merge(self, arr, l, m, r):
        n1 = m - l + 1
        n2 = r - m

        L = [0] * (n1)
        R = [0] * (n2)
        for i in range(0, n1):
            L[i] = arr[l + i]

        for j in range(0, n2):
            R[j] = arr[m + 1 + j]

        i = 0
        j = 0
        k = l
        while i < n1 and j < n2:
            if L[i] <= R[j]:
                arr[k] = L[i]
                i += 1
            else:
                arr[k] = R[j]
                j += 1
            k += 1

        while i < n1:
            arr[k] = L[i]
            i += 1
            k += 1

        while j < n2:
            arr[k] = R[j]
            j += 1
            k += 1

    def mergeSort(self, arr, l, r):
        if l < r:
            m = int((l + (r - 1)) / 2)

            self.mergeSort(arr, l, m)
            self.mergeSort(arr, m + 1, r)
            self.merge(arr, l, m, r)

    def heapify(self, arr, n, i):
        largest = i
        l = 2 * i + 1
        r = 2 * i + 2

        if l < n and arr[i] < arr[l]:
            largest = l

        if r < n and arr[largest] < arr[r]:
            largest = r

        if largest != i:
            arr[i], arr[largest] = arr[largest], arr[i]

            # Heapify the root.
            self.heapify(arr, n, largest)

    def heapSort(self, arr):
        n = len(arr)

        for i in range(n, -1, -1):
            self.heapify(arr, n, i)

        for i in range(n - 1, 0, -1):
            arr[i], arr[0] = arr[0], arr[i]
            self.heapify(arr, i, 0)

    def partition(self, arr, low, high):
        i = (low - 1)
        pivot = arr[high]

        for j in range(low, high):
            if arr[j] <= pivot:
                i = i + 1
                arr[i], arr[j] = arr[j], arr[i]

        arr[i + 1], arr[high] = arr[high], arr[i + 1]
        return (i + 1)

    def quickSort(self, arr, low, high):
        if low < high:
            pi = self.partition(arr, low, high)

            self.quickSort(arr, low, pi - 1)
            self.quickSort(arr, pi + 1, high)

    def counting_sort(self, array):
        m = self.encontrarMaior(array) + 1
        count = [0] * m

        for a in array:
            count[a] += 1

        i = 0
        for a in range(m):
            for c in range(count[a]):
                array[i] = a
                i += 1

    def countingSort(self, arr, exp1):

        n = len(arr)

        # The output array elements that will have sorted arr
        output = [0] * (n)

        # initialize count array as 0
        count = [0] * (10)

        # Store count of occurrences in count[]
        for i in range(0, n):
            index = int((arr[i] / exp1))
            count[(index) % 10] += 1

        # Change count[i] so that count[i] now contains actual
        #  position of this digit in output array
        for i in range(1, 10):
            count[i] += count[i - 1]

            # Build the output array
        i = n - 1
        while i >= 0:
            index = int((arr[i] / exp1))
            output[count[(index) % 10] - 1] = arr[i]
            count[(index) % 10] -= 1
            i -= 1

        # Copying the output array to arr[],
        # so that arr now contains sorted numbers
        i = 0
        for i in range(0, len(arr)):
            arr[i] = output[i]

            # Method to do Radix Sort

    def radixSort(self, arr):

        # Find the maximum number to know number of digits
        max1 = max(arr)

        # Do counting sort for every digit. Note that instead
        # of passing digit number, exp is passed. exp is 10^i
        # where i is current digit number
        exp = 1
        while max1 / exp > 0:
            self.countingSort(arr, exp)
            exp *= 10

    def encontrarMaior(self, arr):
        menor = arr[0]
        for i in arr:
            if i > menor:
                menor = i
        return menor
