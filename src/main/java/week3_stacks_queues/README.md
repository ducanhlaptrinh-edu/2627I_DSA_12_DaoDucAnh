# CTDLGT 2627L - Data Structures & Algorithms

Repository này chứa các bài tập thực hành môn Cấu trúc dữ liệu và Giải thuật thuộc dự án `ctdlgt_2627l_dsa`. Các cấu trúc lõi được cài đặt từ con số 0 (from scratch) bằng mảng co giãn (Resizing Array) thay vì sử dụng thư viện có sẵn, đảm bảo thời gian thực thi trung bình (amortized) là $O(1)$.
## Cấu trúc dự án
Dự án được tổ chức theo chuẩn Maven với file cấu hình `pom.xml`. Toàn bộ mã nguồn thực hành của tuần này được đặt tại nhánh `src/main/java`, bên trong thư mục package `week3_stacks_queues`.
Cấu trúc file chi tiết bao gồm:
```text
ctdlgt_2627l_dsa/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── week3_stacks_queues/
                ├── BalancedBrackets.java
                ├── EqualStacks.java
                ├── QueueUsingTwoStack.java
                ├── SimpleTextEditor.java
                └── SimpleTextEditorUpgrade.java

Môi trường & Công cụ
Ngôn ngữ: Java
Quản lý thư viện/Dự án: Maven
IDE: IntelliJ IDEA