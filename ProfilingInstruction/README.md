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

همانطور که می‌دانید محاسبه اعداد اول کار زمان بری هست. با در نطر گرفتن این موضوع من مسله محاسبه جمع اعداد اول تا یک عدد داده شده را انتخاب کردم. در مرحله اول پیاده سازی به ترتیب همه اعداد را بررسی کردم و برای بررسی هر عدد هم در تابع isPrime شرط بخش پذیری را برای تمام اعداد کوچکتر بررسی کردم. 

<div dir="ltr">

```java
public class Prime {
    public static void main(String[] args) {
        int n = 2000000;
        ArrayList<Integer> primeNumbers = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }

        long sum = 0;
        for (int num : primeNumbers) {
            sum += num;
        }

        System.out.println("Sum of prime numbers up to " + n + " is equal to: " + sum);
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
```

</div>

پس از آن با عدد ۲ میلیون برنامه را اجرا کردم و نتایج زیر بدست آمد. همانطور که مشاهده می‌شود تقریبا تمام زمان صرف تابه isPrime شده است.

![Screenshot from 2024-08-05 16-41-01](https://github.com/user-attachments/assets/a186a09c-af9a-4d91-b6c8-1a2b1c947144)

![Screenshot from 2024-08-05 16-51-35](https://github.com/user-attachments/assets/af2237f5-1488-4dcb-8a1f-3da722c7c04a)

برای بهبود کد از الگوریتم [Sieve of Eratosthenes](https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes) استفاده میکنم و ابتدا تمام اعداد اول تا عدد گفته شده را مشخص میکند و سپس با استفاده ار آن مجموع اعداد را محاسبه میکتیم. این الگوریتم به دو شکل باعث بهبود میشود. اول اینکه تا جذر عدد گفته شده پیش میرود و بعد با استفاده از صرایب اعداد اول، اعداد غیر اول را بدست می‌آورد و نیاز نیست برای تمام اعداد، بخش پذیزی تمام اعداد کوچیکر را بدست آورد. با اینکار سرعت افزایش پیدا میکند.

<div dir="ltr">
  
```java
public class Prime {
    public static void main(String[] args) {
        int n = 2000000;
        boolean[] isPrime = isPrime(n);

        long sum = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                sum += i;
            }
        }

        System.out.println("Sum of prime numbers up to " + n + " is equal to: " + sum);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean[] isPrime(int num) {
        boolean[] isPrime = new boolean[num + 1];
        for (int i = 2; i <= num; i++) {
            isPrime[i] = true;
        }
        for (int p = 2; p * p <= num; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= num; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        return isPrime;
    }
}
```

</div>

کد جدید را با همان عدد ۲ میلیون اجرا میکنیم که نتایج زیر بدست می‌آید و زمان به شدت کاهش یافه است. از چند ثانیه به چند میلی ثانیه تغییر میکند. برای اینکه بتوان پروفایلینگ را انجام داد من یک دستور sleep قرار دادم تا برنامه بسته نشود.

![Screenshot from 2024-08-05 16-44-40](https://github.com/user-attachments/assets/c037fb3a-1f5e-45bd-a5d9-5798511ef899)

![Screenshot from 2024-08-05 16-51-29](https://github.com/user-attachments/assets/ef17a110-abf7-4b9b-9917-1ec975f6929a)
