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

def amount_of_number(list):
    already_counted = []
    number_amount = {}
    for number in list:
        amount = 0
        if number not in already_counted:
            amount = list.count(number)
            already_counted.append(number)
        if amount > 0:
            number_amount[number] = amount

    return number_amount

def calculate_similarity(first_dict, second_dict):
    similarity = 0
    for number in first_dict:
        if number in second_dict:
            similarity += number * first_dict[number] * second_dict[number]

    return similarity

def main():
    file = data_reader("./day1/puzzle1/data.txt")
    lists = divide_data(file)
    first_dict = amount_of_number(lists[0])
    second_dict = amount_of_number(lists[1])
    similarity = calculate_similarity(first_dict, second_dict)
    print("Answer is ", similarity)

main()