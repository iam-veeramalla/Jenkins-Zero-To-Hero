FROM python:3
RUN pip install django==3.2

COPY . .

RUN python manage.py migrate
RUN apt-get update && apt-get install -y python3-setuptools python3-distutils

EXPOSE 8000
CMD ["python","manage.py","runserver","0.0.0.0:8000"]


