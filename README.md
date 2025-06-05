# 墨香云阁
## 概述
基于Springboot+thymeleaf+MyBatis的墨香云阁。主要功能包括：书籍查询，书籍修改，书籍删除，书籍增加，借阅管理，用户管理等。
## 环境配置
开发环境：window 11，Intellij IDEA 2023.2.8

## 逻辑设计
### book表
![{C30DEBC7-2119-4E3A-B8B0-B031190940AC}](https://github.com/user-attachments/assets/e0327057-7a36-4f00-ad2b-cff563c6f990)
![{D5D0AB7D-61D4-450C-9BA0-39E74AB935E5}](https://github.com/user-attachments/assets/61c82fe1-e146-4c48-b962-9bc991b6e854)

![{0FFB6178-746E-4047-9CC2-6BBD02CDDF33}](https://github.com/user-attachments/assets/f333226e-1674-47cf-bb3e-fee937ad453a)
### loan表
![{D9AFF4D4-FD74-429C-97DA-AF843AF1F9F5}](https://github.com/user-attachments/assets/f03e71c3-8d5e-45e7-86b1-180a22ba9393)
![{19415FC8-55AE-4881-8C75-347CB3C64D4B}](https://github.com/user-attachments/assets/72df1b7e-57f1-448e-a889-59e6a2f86ca6)
#### loan表外键
![{2F55FB1F-5BC5-4510-8D1A-305D84CD1387}](https://github.com/user-attachments/assets/90f8fa46-4413-4288-b4a3-a99c61348b3d)
![image](https://github.com/user-attachments/assets/25347086-67eb-4d5b-aaf2-34733b25dd94)

### permission表
![{7525109E-8AA6-4F96-8EB5-01D64CD64BFB}](https://github.com/user-attachments/assets/b4af245a-9758-4514-867f-9921cad10e75)
![{DD713555-36FE-43E7-8AF4-396C93A7B62B}](https://github.com/user-attachments/assets/23fcc41a-0448-4872-8dd6-fe3b118208df)
### role表
![{E00D5A84-190D-454C-8A05-6D00CD72936B}](https://github.com/user-attachments/assets/0ff9ef92-9c23-492c-ad08-7d1ee0c299ff)
![{E1F0114D-DBC4-4C9D-BD6C-EB9B9392B986}](https://github.com/user-attachments/assets/2e169900-751a-414c-8675-88e4036d7a0a)
### role_permission表
![image](https://github.com/user-attachments/assets/e87736d1-378c-45de-8227-6bd1da6e945a)
![{B9A61206-F952-45F1-AC1A-3BAC46BEF057}](https://github.com/user-attachments/assets/b83f2a39-6574-45b4-ac24-4fd239110db7)
![{439DE2EA-3C93-42D1-A316-BFAF6DD8BC45}](https://github.com/user-attachments/assets/3bcc990c-cf03-421e-938c-0c234e483291)
#### role_permission表外键
![{434EEE72-B24D-4FA4-A680-CE43D588931E}](https://github.com/user-attachments/assets/2ef46208-f3d0-4309-9704-0064798f0717)
![image](https://github.com/user-attachments/assets/ca982d91-65c3-49d9-a76c-5509ab691992)

### user表
![{3DA601E9-F2F3-4D67-98BD-6A4333BAD7A1}](https://github.com/user-attachments/assets/8876c531-b392-4b11-9601-5a6d047960e1)
![{F6BC5CD4-8200-4D11-9CF8-15E2D2FF8A76}](https://github.com/user-attachments/assets/d0c92129-5462-440c-ac89-52356b2e407b)
#### user表外键
![{C61E8036-42CD-4A86-8FB0-054B09961B3F}](https://github.com/user-attachments/assets/5a0ec4b7-510c-4efa-bca2-4c1e09a6f214)


# 功能展示
## 拦截器，需要登录得到限权
![{E190B6A9-14AF-4814-A290-93093DF51F2B}](https://github.com/user-attachments/assets/f883774d-44c8-4e5e-8b3d-1382f18f544f)
## 普通用户所拥有的功能
![{92B0FF0E-D1C8-4215-AB0C-F1B9FAFFAD5B}](https://github.com/user-attachments/assets/6e342d4a-ebe0-46e1-b581-dcee0c55f462)
- 用户借阅后需要得到管理员的同意，用户还可以直接归还书籍
![{9C47117C-F386-4AE3-AE05-0577DE8CA97E}](https://github.com/user-attachments/assets/7496bcd2-d0d5-432f-967e-6b252b3d3403)
## 管理员所拥有的功能
![{BBA523B7-35C2-4B6F-B3B1-EFAB440A59C2}](https://github.com/user-attachments/assets/e8ca7db4-c409-4f00-9e8d-44999da54e5b)
- 添加书籍
![{C44442D5-93CA-4FD6-A34E-F302C070C754}](https://github.com/user-attachments/assets/28ade9aa-34c4-4b10-aebf-20a686961489)
- 修改和删除
![{70A28A8B-51CA-4AE8-8892-DA3AFFFCE4EA}](https://github.com/user-attachments/assets/9789d060-8b53-42d8-8289-5b6871ff04e1)
- 管理员可以管理普通用户的借阅请求
![{951A8A3E-D7BA-42AD-8864-A4C915A067E8}](https://github.com/user-attachments/assets/52c4bc9f-a54a-4f90-aa09-46e7e8d80d55)

- 管理员可以查看每个用户的借阅信息
![image](https://github.com/user-attachments/assets/c7d512f8-5438-415e-95ad-cb462872e7c2)
![image](https://github.com/user-attachments/assets/ba30f4d4-d56e-4d4f-a111-70843924f379)

## 系统管理员所拥有的功能
![image](https://github.com/user-attachments/assets/e43b7077-7df0-48a4-b95c-cac064405809)
- 系统管理员可以管理用户的信息
![image](https://github.com/user-attachments/assets/4e574dd2-e491-4709-92d4-008611cb2c6e)
