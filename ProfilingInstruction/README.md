## بخش اول: پروژه‌ی ProfilingTest


در ابتدا مطابق توضیحات YourKit را نصب می‌کنیم و از مهلت ۱۵ روزه‌ی آن استفاده می‌کنیم. همچنین پلاگین آن را نصب می‌کنیم:
<img width="737" alt="Screenshot 2024-08-04 at 4 16 20 PM" src="https://github.com/user-attachments/assets/4904539c-1730-4c92-8767-d0a7617f52de">

<img width="1289" alt="Screenshot 2024-08-04 at 4 20 18 PM" src="https://github.com/user-attachments/assets/aa4b4e73-fae7-4efe-8096-a1987b0aa2ac">

حال همانطور که خواسته شده JavaCup را با YourKit اجرا می‌کنیم:

![Screenshot 2024-08-04 at 4 33 30 PM](https://github.com/user-attachments/assets/471901ba-ba3e-4ba7-b19f-bf0300fbf675)

و به برنامه ورودی می‌دهیم:

<img width="1438" alt="Screenshot 2024-08-04 at 4 38 40 PM" src="https://github.com/user-attachments/assets/8d04b63d-cb1d-4373-9f64-d01cbdc32b3a">

اکنون می‌توانیم از برنامه‌ی YourKit آمار منابع را بررسی کنیم:
<img width="1293" alt="Screenshot 2024-08-04 at 4 38 27 PM" src="https://github.com/user-attachments/assets/e7e82d4d-b46c-4e86-a5dc-e3df2b203a05">

همانطور که مشخص است تابع temp منابع زیادی مصرف می‌کند. کد این تابع به شکل زیر می‌باشد:

<img width="490" alt="Screenshot 2024-08-04 at 4 39 47 PM" src="https://github.com/user-attachments/assets/5e94d869-1d3e-4182-b4c3-2d71993bebf9">

همانطور که مشخص است، اندازه آرایه تعیین نشده و از طرفی برای اضافه کردن اعداد جدید نیز از add استفاده شده که همین‌ها منابع زیادی مصرف می‌کنند. بنابراین تابع را به شکل زیر تغییر می‌دهیم:
<img width="386" alt="Screenshot 2024-08-04 at 6 52 15 PM" src="https://github.com/user-attachments/assets/60b2dc04-dbc7-4eb2-b8ed-31a34eac320d">

با این تغییرات هم آرایه اندازه‌ش مشخص است و هم برای add کردن منبع زیادی استفاده نمی‌شود و برنامه را مجدد با YourKit ران می‌کنیم:
<img width="728" alt="Screenshot 2024-08-04 at 4 46 10 PM" src="https://github.com/user-attachments/assets/65fb9380-aab0-439d-bcae-100740c31c94">

و خروجی YourKit به این شکل می‌شود:

<img width="969" alt="Screenshot 2024-08-04 at 4 46 04 PM" src="https://github.com/user-attachments/assets/84075ba5-a4d9-4785-ac04-f63e0e5af7a0">

که تخصیص منابع به شدت کاهش یافته. همچنین یک تست دیگر نیز با خروجی Yes انجام دادیم و تخصیص منابع مانند مثال No بود:
<img width="733" alt="Screenshot 2024-08-04 at 4 46 53 PM" src="https://github.com/user-attachments/assets/32b913f1-b424-40c7-90c0-570b67ee3f88">




## بخش دوم: یک پروژه‌ی دیگر
