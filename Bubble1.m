function [ compcounts ] = Bubble1( a,n )
%UNTITLED5 Summary of this function goes here
%   Detailed explanation goes here

compcounts=0;
%arr=a;
for outer=1:n
    for inner=1:n-outer
        compcounts=compcounts+1;
        if a(inner) > a(inner+1)
            temp1=a(inner);
            a(inner)=a(inner+1);
            a(inner+1)=temp1;
        end
    end
end


end

