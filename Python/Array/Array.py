import random


class Array(object):

    def getArray(self, size):
        array = []
        array = [random.randint(0, 100) for i in range(size)]
        return array
