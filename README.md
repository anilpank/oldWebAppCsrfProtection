# oldWebAppCsrfProtection
Protecting an old java based web application from csrf attacks

Many of the older java/j2ee based web applications that we end up working on/maintaining on, are not on latest spring or play or other cool frameworks which have automatic csrf protection features.

If you are one of those, worry not, simple Servlet Filters and some javascript is all that you need.
Add below 2 filters in your web.xml 
- [SetCsrfTokenFilter.java](https://github.com/anilpank/oldWebAppCsrfProtection/blob/master/src/org/csrf/filters/SetCsrfTokenFilter.java)

- [VerifyCsrfTokenFilter.java]
(https://github.com/anilpank/oldWebAppCsrfProtection/blob/master/src/org/csrf/filters/VerifyCsrfTokenFilter.java)

In all forms/wherever you are doing post requests inject a hidden field called csrfToken, Populate it's value by reading it from cookie.
Sample example of jsp page where there is a form
[SampleForm.jsp]
(https://github.com/anilpank/oldWebAppCsrfProtection/blob/master/WebContent/SampleForm.jsp)

And a sample implementation of reading cookie value of csrfToken using javascript
[CookieReader.js]
(https://github.com/anilpank/oldWebAppCsrfProtection/blob/master/WebContent/CookieReader.js)

# [Bespoke Solutions](http://www.ojblabs.com)
Brought to you by [OjbLabs](http://www.ojblabs.com)


