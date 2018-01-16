clear all
xB1=zeros(10,1);
yB1=zeros(10,1);
xB2=zeros(10,1);
yB2=zeros(10,1);
xI3=zeros(10,1);
yI3=zeros(10,1);
k=0;
for n=10:10:100
    k=k+1;
   arr1=round(rand(n,1)*100);
   xB1(k)=n;
   yB1(k) = Bubble1(arr1,n);
   xB2(k)=n;
   yB2(k) = Bubble2(arr1,n);
   xI3(k) = n;
   yI3(k) = Insertion1(arr1,n);
   
end
plot(xB1,yB1,xB2,yB2,xI3,yI3)
title('Graph comparisions between bubble sort and insertion sort')
legend('y=Bubble Sort1','y=Bubble Sort2','y=Insertion Sort1','location','west')
xlabel('no of elements')
ylabel('no of comparisions')



