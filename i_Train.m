function [aTime,aGradient] = i_Train(in,out,nLearn,nEpoch,nGoal,sOption)
try
    aTime = [];
    aGradient = [];
    net = newff(in,out,[],{},sOption);
    net.trainParam.lr = nLearn;
    net.trainParam.epochs = nEpoch;
    net.trainParam.goal=nGoal;
    net.trainParam.max_fail=20;
    [net,tr] = train(net,in,out);
    
    aTime = tr.epoch;
    aGradient = tr.gradient;  
    rout = sim(net,in);
   
   % plot(in,out,'b*',in, rout,'ro');
    
    clear net;
catch
    
    rethrow(lasterror())
end
end