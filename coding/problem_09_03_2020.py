# Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

# Solution 1: O(n ** 2)
# for each element in the array at index i
# iterate through i+1 to n and sum arr[i] + arr[j]
# check if the sum is equal to k if equal
# set the found = true and break


def sol1(arr, k):
    found = False
    for i in range(len(arr)):
        for j in range(i+1, len(arr)):
            if (arr[i] + arr[j]) == k:
                found = True
                break
    if found:
        print('yes')
    else:
        print('no')

# Sort the given array and have two pointers one
# at the start say i and the other at the end of list
# say j if arr[i] + arr[j] == k then found else if
# arr[i] + arr[j] < k then i+1 else j-1
# do this until i != j


def sol2(arr, k):
    found = False
    arr.sort()
    i = 0
    j = len(arr) - 1
    while i < j:
        sum_val = arr[i] + arr[j]
        if sum_val == k:
            found = True
            break
        elif sum_val < k:
            i += 1
        else:
            j -= 1
    if found:
        print('yes')
    else:
        print('no')


# solution 3 : iterate each element and check if the
# complementary element is present in hash if yes then
# found else insert the element into hash and continue
# till end of list

def sol3(arr, k):
    found = False
    hash_data = set()
    for i in arr:
        if k - i in hash_data:
            found = True
            break
        hash_data.add(i)

    if found:
        print('yes')
    else:
        print('no')


if __name__ == '__main__':
    arr = list(map(int, input().split()))
    k = int(input())
    sol1(arr, k)
    sol2(arr, k)
    sol3(arr, k)
