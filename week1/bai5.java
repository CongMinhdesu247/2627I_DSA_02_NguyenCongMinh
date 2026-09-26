/*
    không thể là biểu diễn parent-link của một cấu trúc dữ liệu weighted quick union
    Lý do :
        Quy tắc tạo liên kết: Trong Weighted Quick Union, một nút chỉ có thể nhận thêm con trực
        tiếp khi nó đang đóng vai trò là gốc (root). Một khi đã trỏ tới nút khác,
        nó không bao giờ nhận thêm con nữa

        Kích thước cây gốc 0: Các phần tử thuộc nhánh của nút 0 gồm {0, 1, 2, 3, 4, 6, 8}.
        Tất cả 7 phần tử này bắt buộc phải thuộc cây gốc 0 trước khi nút 0 bị nối sang nút 5.
        Do đó, tại thời điểm nối, kích thước cây của nút 0 tối thiểu phải bằng 7

        Kích thước cây gốc 5: Mảng có tổng cộng 10 phần tử (từ 0 đến 9).
        Cây gốc 5 trước khi hợp nhất chỉ chứa tối đa các phần tử còn lại là {5, 7, 9},
        tức kích thước tối đa chỉ bằng 3

        Mâu thuẫn quy tắc link-by-size: Thuật toán bắt buộc phải trỏ gốc của
        cây nhỏ hơn vào gốc của cây lớn hơn. Vì Size(0) = 7 > Size(5) <= 3,
        cấu trúc phải tạo ra parent[5] = 0 chứ không thể là parent[0] = 5
*/