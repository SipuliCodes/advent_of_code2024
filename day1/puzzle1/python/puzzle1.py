def data_reader(path):
    file_data = []
    file = open(path, "r")

    for line in file:
        file_data.append(line)

    return file_data
    
def divide_data(data):
    first_list = []
    second_list = []

    for d in data:
        first, second = d.split("   ")
        first_list.append(int(first))
        second_list.append(int(second))
    
    combined_list = []
    combined_list.append(first_list)
    combined_list.append(second_list)

    return combined_list

def calculate_difference(first_list, second_list):
    sorted_first_list = sorted(first_list)
    sorted_second_list = sorted(second_list)

    difference = 0

    for i in range(0, len(sorted_first_list)):
        difference += abs(sorted_first_list[i] - sorted_second_list[i])
    
    return difference

def main():
    file = data_reader("./day1/puzzle1/data.txt")
    lists = divide_data(file)
    difference = calculate_difference(lists[0], lists[1])
    print("Answer is ", difference)

main()