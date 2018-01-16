function [ compcounts3 ] = Selectio1( a,n )
%UNTITLED5 Summary of this function goes here
%   Detailed explanation goes here
%clear all
pos=0;
value=0;
compcounts3=0;
for i1=1:n
    value=a(i1);
    k1=i1+1;
    for j2=k1:n
        compcounts3=compcounts3+1;
        if a(j2)<value
            pos=j2;
            value=a(j2);
        end
        
    end
    temp=a(i1);
    a(i1)=value;
    a(pos)=temp;
    
end


    
end
