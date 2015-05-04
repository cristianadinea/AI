function varargout = NNBackPropagation(varargin)
% NNBACKPROPAGATION M-file for NNBackPropagation.fig
%      NNBACKPROPAGATION, by itself, creates a new NNBACKPROPAGATION or raises the existing
%      singleton*.
%
%      H = NNBACKPROPAGATION returns the handle to a new NNBACKPROPAGATION or the handle to
%      the existing singleton*.
%
%      NNBACKPROPAGATION('CALLBACK',hObject,eventData,handles,...) calls the local
%      function named CALLBACK in NNBACKPROPAGATION.M with the given input arguments.
%
%      NNBACKPROPAGATION('Property','Value',...) creates a new NNBACKPROPAGATION or raises the
%      existing singleton*.  Starting from the left, property value pairs are
%      applied to the GUI before NNBackPropagation_OpeningFcn gets called.  An
%      unrecognized property name or invalid value makes property application
%      stop.  All inputs are passed to NNBackPropagation_OpeningFcn via varargin.
%
%      *See GUI Options on GUIDE's Tools menu.  Choose "GUI allows only one
%      instance to run (singleton)".
%
% See also: GUIDE, GUIDATA, GUIHANDLES

% Edit the above text to modify the response to help NNBackPropagation

% Last Modified by GUIDE v2.5 21-Jan-2012 20:02:36

% Begin initialization code - DO NOT EDIT
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @NNBackPropagation_OpeningFcn, ...
                   'gui_OutputFcn',  @NNBackPropagation_OutputFcn, ...
                   'gui_LayoutFcn',  [] , ...
                   'gui_Callback',   []);
if nargin && ischar(varargin{1})
    gui_State.gui_Callback = str2func(varargin{1});
end

if nargout
    [varargout{1:nargout}] = gui_mainfcn(gui_State, varargin{:});
else
    gui_mainfcn(gui_State, varargin{:});
end
% End initialization code - DO NOT EDIT


% --- Executes just before NNBackPropagation is made visible.
function NNBackPropagation_OpeningFcn(hObject, eventdata, handles, varargin)
% This function has no output args, see OutputFcn.
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
% varargin   command line arguments to NNBackPropagation (see VARARGIN)

% Choose default command line output for NNBackPropagation
handles.output = hObject;

% Update handles structure
guidata(hObject, handles);

% UIWAIT makes NNBackPropagation wait for user response (see UIRESUME)
% uiwait(handles.figure1);


% --- Outputs from this function are returned to the command line.
function varargout = NNBackPropagation_OutputFcn(hObject, eventdata, handles) 
% varargout  cell array for returning output args (see VARARGOUT);
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Get default command line output from handles structure
varargout{1} = handles.output;


% --- Executes on selection change in trainMenu.
function trainMenu_Callback(hObject, eventdata, handles)
% hObject    handle to trainMenu (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: contents = get(hObject,'String') returns trainMenu contents as cell array
%        contents{get(hObject,'Value')} returns selected item from trainMenu


% --- Executes during object creation, after setting all properties.
function trainMenu_CreateFcn(hObject, eventdata, handles)
% hObject    handle to trainMenu (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: popupmenu controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function learnEdit_Callback(hObject, eventdata, handles)
% hObject    handle to learnEdit (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of learnEdit as text
%        str2double(get(hObject,'String')) returns contents of learnEdit as a double


% --- Executes during object creation, after setting all properties.
function learnEdit_CreateFcn(hObject, eventdata, handles)
% hObject    handle to learnEdit (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function fileEdit_Callback(hObject, eventdata, handles)
% hObject    handle to fileEdit (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of fileEdit as text
%        str2double(get(hObject,'String')) returns contents of fileEdit as a double


% --- Executes during object creation, after setting all properties.
function fileEdit_CreateFcn(hObject, eventdata, handles)
% hObject    handle to fileEdit (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end


% --- Executes on button press in loadBtn.
function loadBtn_Callback(hObject, eventdata, handles)
[sFile,sDir] = uigetfile({'*.mat'},'Select file to load');
if isequal(sFile,0)
    return;
end
set(handles.fileEdit,'string',fullfile(sDir,sFile));



function epochEdit_Callback(hObject, eventdata, handles)


% --- Executes during object creation, after setting all properties.
function epochEdit_CreateFcn(hObject, eventdata, handles)

if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function goalEdit_Callback(hObject, eventdata, handles)


% --- Executes during object creation, after setting all properties.
function goalEdit_CreateFcn(hObject, eventdata, handles)

if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end

function [sMessage,nValue] =  i_checkValue(sValue,sType)
sMessage = '';
nValue=-1;
if isempty(sValue)
    sMessage = sprintf('%s value cannot be empty!',sType);
    return;
end
nValue=str2num(sValue);
if isempty(nValue)
    sMessage = sprintf('%s value should be a number!',sType);
    return;
end
if nValue<0
    sMessage=sprintf('%s value should be a positive number!',sType);
    return;
end
if strcmpi(sType,'epoch')
    if nValue==0
        sMessage = sprintf('%s value should not be zero!',sType);
        return;
    end
end



% --- Executes on button press in trainBtn.
function trainBtn_Callback(hObject, eventdata, handles)
sLearn = get(handles.learnEdit,'string');
[sMessage,nLearn] = i_checkValue(sLearn,'Learning Rate');
if ~isempty(sMessage)
    msgbox(sMessage,'Learning Rate','err');
    return;
end
sEpoch = get(handles.epochEdit,'string');
[sMessage,nEpoch] =i_checkValue(sEpoch,'Epoch');
if ~isempty(sMessage)
    msgbox(sMessage,'Epoch','err');
    return;
end
sPerf = get(handles.goalEdit,'string');
[sMessage,nGoal] = i_checkValue(sPerf,'Performance Goal');
if ~isempty(sMessage)
    msgbox(sMessage,'Epoch','err');
    return;
end
sFile = get(handles.fileEdit,'string');
if isempty(sFile)
    msgbox('Please specify a data source!','File - load data','err');
    return;
end
if ~exist(sFile,'file')
    msgbox('The specified data source does not exist or is not a file!','File - load data','err');
    return;
end
if isempty(strfind(sFile,'.m')) && isempty(strfind(sFile,'.mat'))
    msgbox('Supported file type is .mat!','File - load data','err');
    
    return
end
casOption = get(handles.trainMenu,'string');
sOption = casOption{get(handles.trainMenu,'value')};
[sDir,sFile] = fileparts(sFile);
sCWD = pwd;
cd(sDir);
load(sFile);
cd(sCWD);
[aTime,aGradient] = i_Train(in,out,nLearn,nEpoch,nGoal,sOption);
grid(handles.plotHandle,'on');
plot(handles.plotHandle,aTime,aGradient,'b');



% --- Executes on button press in saveBtn.
function saveBtn_Callback(hObject, eventdata, handles)
[sFile,sDir]=uiputfile('plot.png','Save current plot');
saveas(handles.plotHandle,fullfile(sDir,sFile));


