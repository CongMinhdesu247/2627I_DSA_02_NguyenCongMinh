/*
Testcase
    n = 3
    Chuỗi phép toán union(2,0), sau đó union(0,1)
    cặp cần so sánh i = 0 và j = 2

Code chạy:
1) union(2,0): Mảng thành leader = [0,1,0]
2) union(0,1): 
    Tại i = 0, leader[0] bị ghi đè thành 1
    Tại i = 2, phép so sánh leader[2] == leader[0] trở thành 0 == 1 (Sai) vì
    leader[0] đã bị đổi trước đó. Do vậy leader[2] bị bỏ qua.
3) Kết quả: Mảng cuối là leader = [1, 1, 0] -> find(0) = 1 khác find(2) = 0.

Chốt lại lỗi : leader[p] bị thay đổi ngay trong vòng lặp trước khi
duyệt tới các phần tử nằm phía sau p

*/