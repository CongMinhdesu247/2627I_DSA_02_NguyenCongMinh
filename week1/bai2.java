/*

(a) Số lượng thành phần liên thông: 1
    Giải thích: Chuỗi n-1 thao tác union() nối tất cả các phần tử từ 1 đến n-1 với 0,
    hợp nhất toàn bộ n phần tử thành 1 tập hợp duy nhất
(b) Số lần cập nhật mảng trong Quick-Find: 1/2 n^2
    Giải thích:
        union(0, 1) cập nhật 1 phần tử (chuyển 0 thành 1)
        union(0, 2) cập nhật 2 phần tử (chuyển 0, 1 thành 2)
        union(0, 2) cập nhật 2 phần tử (chuyển 0, 1 thành 2)
        Tổng số lần cập nhật: 1 + 2 + 3 + ... + (n-1) = 1/2 n^2
(c) Số lần truy cập mảng của find(0) trong Quick-Union: O(n)
    Giải thích: 
    Cây bị suy biến thành một chuỗi tuyến tính:0 -> 1 -> 2 -> ... -> n-1. 
    Thao tác find(0) phải duyệt dọc theo đường đi có độ dài n-1 để tìm đến gốc n-1, 
    tốn O(n) bước -> Theta(n) lần truy cập mảng
(d) Số lần truy cập mảng của find(0) trong Weighted Quick-Union: O(1)
    Giải thích:
        union(0, 1): Hai cây cùng kích thước 1 -> nút 1 trỏ vào nút 0 (kích thước cây gốc 0 tăng lên 2)

        union(0, k) với k >= 2: Cây chứa 0 luôn có kích thước lớn hơn cây chứa k (kích thước 1), 
        do đó nút k luôn được nối trực tiếp vào nút gốc 0

        Cấu trúc thu được là cây dạng sao có chiều cao 1 với 0 làm gốc. 
        Thao tác find(0) dừng lại ngay lập tức tại 0 chỉ sau O(1) lần truy cập mảng
*/