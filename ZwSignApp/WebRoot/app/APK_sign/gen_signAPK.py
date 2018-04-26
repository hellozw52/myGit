
# coding: utf-8

# In[13]:


# -*- coding: utf-8 -*-


"""
@version: ??
@author: Binge
@file: gen_signAPK.py
@time: 2018/4/12 10:06
@description:
环境要求：python3环境

py文件 在目录 APK_sign/
搜索app_original目录下所有apk文件，然后在app_sign目录批量生成apk签名文件。
同时生成日志文件：py_sign_log.txt

"""

import os 
import subprocess
import time

file_dir = r'D:/apache-tomcat-7.0.26/webapps/ZwSignApp/app/APK_sign/app_original'

file_names = []
output_names = []

def get_files(file_dir):
    for file in os.listdir(file_dir):
        file_names.append(file)
    return file_names

def func(name):
    body,ext = name.split('.')
    return body + '_signed' + '.' + ext
        
file_names = get_files(file_dir)
output_names = list(map(func, file_names))


output_dir = r'D:/apache-tomcat-7.0.26/webapps/ZwSignApp/app/APK_sign/app_sign'

with open(r"D:/apache-tomcat-7.0.26/webapps/ZwSignApp/app/APK_sign/py_sign_log.txt",'w',encoding='utf-8') as fhandle:

    for file_name, output_name in zip(file_names,output_names):
        output_dir_file = os.path.join(output_dir,output_name)
       
        print('============================================================')
        print('to sign file: %s' % file_name)
        cmd_line = "D:/apache-tomcat-7.0.26/webapps/ZwSignApp/app/APK_sign/sign_apk.bat" 
        params = [cmd_line, file_name, output_name]
        cmd = ' '.join(params)
        pipe = subprocess.Popen(cmd, shell=True,stdout=fhandle).stdout 
        print('generating ...')
        time.sleep(1)
        
        print('well done!: %s' % output_name)
print('============================================================')
print('all finished!')
print('************************************************************')

