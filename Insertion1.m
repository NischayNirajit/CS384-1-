function [ compcounts3 ] = Insertion1( a,n )
%UNTITLED5 Summary of this function goes here
%   Detailed explanation goes here
%clear all
key=0;
compcounts3=0;

for i=2:n
    key=a(i);
    j1=i-1;
    compcounts3=compcounts3+1;
    
    while j1>=1 && a(j1)>=key
        %compcounts3=compcounts3+1;
        a(j1+1)=a(j1);
        j1=j1-1;
        
    end
    a(j1+1)=key;
    
end
