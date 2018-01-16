function [ compcounts2 ] = Bubble2( a,n )
%UNTITLED5 Summary of this function goes here
%   Detailed explanation goes here
%clear all
compcounts2=0;

for outer=1:n
    flag=0;
    for inner=1:n-outer
        compcounts2=compcounts2+1;
        if a(inner) > a(inner+1)
            temp1=a(inner);
            a(inner)=a(inner+1);
            a(inner+1)=temp1;
            flag=flag+1;
        end
    end
    if flag==0
        break
    end
end