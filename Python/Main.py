from Array import Array
from Sorts import Sorts


class Main(object):
    if __name__ == '__main__':
        arr = Array.Array()
        sort = Sorts.Sort()

        vetor = arr.getArray(10)
        sort.radixSort(vetor)
        print(vetor)
