
# آزمایش BDD

## مسئله اول
برای شروع یک پروژه ی maven ایجاد کرده و دیپیندنسی های میون گفته شده را به آن اضافه میکنیم و با اجرای تست طبق دستور کار پیغام موفقیت زیر را میبینیم و لایبرری های مورد نیاز نیز در این قسمت اضافه میشوند.
![image](https://github.com/user-attachments/assets/0cdb66c1-74fe-4792-9b20-c85a5f1cb6c9)
![image](https://github.com/user-attachments/assets/81bf773c-f2cc-4edc-b38d-f61926899d6f)



حال فولدر resources را ساخته و به عنوان Test Resource Root انتخاب میکنیم.
![image](https://github.com/user-attachments/assets/068d7deb-d577-42a1-b523-a88ac6f56231)




سناریو زیر را در فایل calculator.featue طبق دستور کار قرار میدهیم.
![image](https://github.com/user-attachments/assets/51e25eb4-87ab-48c7-9920-bb03058b113c)



در فایل MyStepdefs.java توابعی که توسط خود اینتلیجی جنریت شدند را پر میکنیم.

![image](https://github.com/user-attachments/assets/054455d7-2465-4875-b78e-56ae2e962246)


پس از تعریف کلاس calculator و پر کردن متود add، تست ها را ران میکنیم که یک سناریو موفقیت آمیز است:
![image](https://github.com/user-attachments/assets/c5562f5e-b7ea-449b-844c-aec3271a80ac)


طبق دستور کار فایل RunnerTest.java را میسازیم تا از جزئیات اجزای تست ها با خبر شویم.

![image](https://github.com/user-attachments/assets/ba27075d-a913-4f40-9ce9-1dba3ce2cf12)


با تغییر مقدار Expected به 30000 میبینیم که تست fail میشود
![image](https://github.com/user-attachments/assets/1cef5179-e63e-418f-bfb6-31fd4aebf5de)
حال به فایل سناریوها، outline گفته شده را اضافه میکنیم.
![image](https://github.com/user-attachments/assets/e0130d00-984f-4408-9601-2001a7499425)
با اجرای این تست به ارور missing value برای برخی تست ها میخوریم.
![image](https://github.com/user-attachments/assets/879abe72-c013-4261-b994-c0c94a550d09)
این به این دلیل است که یکی از سناریوها عدد 1- را ورودی میدهد که توسط رجکس (+d\) قابل شناسایی نیست. برای رفع این مشکل از رجکس "^Two input values, ([+-]?\\d+) and ([+-]?\\d+)$" استفاده میکنیم.
![image](https://github.com/user-attachments/assets/5717bd9f-e9b6-4a21-859a-e59c19d3729d)




