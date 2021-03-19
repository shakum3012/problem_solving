"""
The algorithm is similar to the merge function in the merge sort algorithm.
The arrays are traversed with two different pointers with a separate counter
variable to stop when the middle of the combined array is reached.

Time complexity : O(n)
Space complexity : O(1)
"""


def find_median_sorted_arrays(nums1, nums2):
    l1 = len(nums1)
    l2 = len(nums2)
    total_elements = l1 + l2
    min_index = total_elements // 2
    if total_elements % 2 == 0:
        min_index -= 1

    i = 0
    j = 0
    cur_index = -1
    mid_element = None
    current_arr = None
    while cur_index < min_index and i < l1 and j < l2:
        if nums1[i] < nums2[j]:
            current_arr = 1
            i += 1
        else:
            current_arr = 2
            j += 1
        cur_index += 1

    if cur_index < min_index:
        if i == l1:
            while cur_index < min_index:
                current_arr = 2
                j += 1
                cur_index += 1
        else:
            while cur_index < min_index:
                current_arr = 1
                i += 1
                cur_index += 1

    if current_arr == 2:
        mid_element = nums2[j - 1]
    elif current_arr == 1:
        mid_element = nums1[i - 1]

    if total_elements % 2 == 0:
        if i >= l1:
            mid_element += nums2[j]
        elif j >= l2:
            mid_element += nums1[i]
        elif nums1[i] >= nums2[j]:
            mid_element += nums2[j]
        elif nums1[i] < nums2[j]:
            mid_element += nums1[i]

        mid_element /= 2

    return mid_element


median = find_median_sorted_arrays([1, 2], [3])
print(median)
