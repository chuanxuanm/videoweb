# videoweb
spring bppt+mybaties,使用了redies对可能频繁读取的数据库信息进行预先redis储存，使用kafaka对离线消息进行储存，对websocekt进行用户之间的通讯。
以下是接口文档：

## 获取所有院校信息组件
URL

`POST http://120.55.14.62:8081/college/getCollegeAll`

请求参数

<table>
  <thead>
    <tr>
      <th>参数名</th>
      <th>类型</th>
      <th>必填</th>
      <th>描述</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>page</td>
      <td>Number</td>
      <td>是</td>
      <td>请求的页码数，每页默认返回5条数据</td>
    </tr>
  </tbody>
</table>

<table>
  <thead>
    <tr>
      <th>参数名</th>
      <th>类型</th>
      <th>描述</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>collegeId</td>
      <td>Number</td>
      <td>院校id</td>
    </tr>
    <tr>
      <td>collegeName</td>
      <td>String</td><table>
  <thead>
    <tr>
      <th>参数名</th>
      <th>类型</th>
      <th>必填</th>
      <th>描述</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>page</td>
      <td>Number</td>
      <td>是</td>
      <td>请求的页码数，每页默认返回5条数据</td>
    </tr>
  </tbody>
</table>

<table>
  <thead>
    <tr>
      <th>参数名</th>
      <th>类型</th>
      <th>描述</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>collegeId</td>
      <td>Number</td>
      <td>院校id</td>
    </tr>
    <tr>
      <td>collegeName</td>
      <td>String</td>
      <td>院校名称</td>
          </tr>
  </tbody>
</table>
      
    </tr>
  </tbody>
</table>

json
Copy
{
    "collegeId": 1,
    "collegeName": "清华大学"
},
{
    "collegeId": 2,
    "collegeName": "北京大学"
}

获取院校总数
URL

`POST http://120.55.14.62:8081/college/getPage`

响应参数

<table>
  <thead>
    <tr>
      <th>参数名</th>
      <th>类型</th>
      <th>描述</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>total</td>
      <td>Number</td>
      <td>院校总数</td>
    </tr>
  </tbody>
</table>
响应示例

Copy
{
    "total": 100
}


## HomeView组件
接口文档
1. 获取所有周报
URL: http://120.55.14.62:8081/weeklyReport/getWeeklyReportAll

Method: POST

请求参数:

<table>
  <thead>
    <tr>
      <th>参数名</th>
      <th>类型</th>
      <th>必填</th>
      <th>描述</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>page</td>
      <td>Number</td>
      <td>是</td>
      <td>页码</td>
    </tr>
    <tr>
      <td>collegeId</td>
      <td>String</td>
      <td>是</td>
      <td>学院编号</td>
    </tr>
  </tbody>
</table>
返回值:

返回一个数组，每个元素包含以下字段：

<table>
  <thead>
    <tr>
      <th>字段名</th>
      <th>类型</th>
      <th>描述</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>reportId</td>
      <td>Number</td>
      <td>报告编号</td>
    </tr>
    <tr>
      <td>collegeName</td>
      <td>String</td>
      <td>学院名称</td>
    </tr    <tr>
      <td>companyName</td>
      <td>String</td>
      <td>企业名称</td>
    </tr>
    <tr>
      <td>contactPerson</td>
      <td>String</td>
      <td>联系人姓名/联系方式</td>
    </tr>
    <tr>
      <td>interactionType</td>
      <td>String</td>
      <td>互动类型</td>
    </tr>
    <tr>
      <td>attendees</td>
      <td>String</td>
      <td>参加人员</td>
    </tr>
    <tr>
      <td>cooperationType</td>
      <td>String</td>
      <td>合作业务类型</td>
    </tr>
    <tr>
      <td>cooperationDetails</td>
      <td>String</td>
      <td>合作业务详细说明</td>
    </tr>
    <tr>
      <td>recruitmentNeeds</td>
      <td>String</td>
      <td>未来招聘需求</td>
    </tr>
    <tr>
      <td>urgentMajor</td>
      <td>String</td>
      <td>急需招聘专业</td>
    </tr>
    <tr><td>reportDate</td>
    <td>Date</td>
      <td>创建时间</td>
    </tr>
  </tbody>
</table>
1. 获取总页数
URL: http://120.55.14.62:8081/weeklyReport/getPage

Method: POST

请求参数:

<table>
  <thead>
    <tr>
      <th>参数名</th>
      <th>类型</th>
      <th>必填</th>
      <th>描述</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>page</td>
      <td>Number</td>
      <td>是</td>
      <td>页码</td>
    </tr>
    <tr>
      <td>collegeId</td>
      <td>String</td>
      <td>是</td>
      <td>学院编号</td>
    </tr>
  </tbody>
</table>
返回值:

返回一个数字，表示总页数。

3. 获取指定时间段的总页数
URL: http://120.55.14.62:8081/weeklyReport/getPageTime

Method: POST

请求参数:

<table>
  <thead>
    <tr>
      <th>参数名</th>
      <th>类型</th>
      <th>必填</th>
      <th>描述</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>page</td>
      <td>Number</td>
      <td>是</td>
      <td>页码</td>
    </tr>
    <tr>
      <td>collegeId</td>
      <td>String</td>
      <td>是</td>
      <td>学院编号</td>
    </tr>
    <tr>
      <td>startTime</td>
      <td>String</td>
      <td>是</td>
      <td>开始时间</td>
    </tr>
    <tr>
      <td>endTime</td>
      <td>String</td>
      <td>是</td>
      <td>结束时间</td>
    </tr>
  </tbody>
</table>
返回值:

返回一个数字，表示总页数。

4. 根据公司名称获取总页数
URL: http://120.55.14.62:8081/weeklyReport/getPageCompany

Method: POST

请求参数:
<table>
  <thead>
    <tr>
      <th>参数名</th>
      <th>类型</th>
      <th>必填</th>
      <th>描述</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>page</td>
      <td>Number</td>
      <td>是</td>
      <td>页码</td>
    </tr>
    <tr>
      <td>collegeId</td>
      <td>String</td>
      <td>是</td>
      <td>学院编号</td>
    </tr>
    <tr>
      <td>companyName</td>
      <td>String</td>
     <td>是</td>
      <td>公司名称</td>
    </tr>
  </tbody>
</table>
返回值:

返回一个数字，表示总页数。

5. 插入周报
URL: http://120.55.14.62:8081/weeklyReport/insertWeeklyReport

Method: POST

请求参数:

一个包含以下字段的 JSON 对象：

<table>
  <thead>
    <tr>
      <th>字段名</th>
      <th>类型</th>
      <th>必填</th>
      <th>描述</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>companyName</td>
      <td>String</td>
      <td>是</td>
      <td>公司名称</td>
    </tr>
    <tr>
      <td>contactPerson</td>
      <td>String</td>
      <td>是</td>
      <td>联系人姓名/联系方式</td>
    </tr>
    <tr>
      <td>interactionType</td>
      <td>String</td>
      <td>是</td>
      <td>互动类型</td>
    </tr>
    <tr>
      <td>attendees</td>
      <td>String</td>
      <td>是</td>
      <td>参加人员</td>
    </tr>
    <tr>
      <td>cooperationType</td>
      <td>String</td>
      <td>是</td>
      <td>合作业务类型</td>
    </tr>
    <tr>
      <td>cooperationDetails</td>
      <td>String</td>
      <td>是</td>
      <td>合作业务详细说明</td>
    </tr>
    <tr>
      <td>recruitmentNeeds</td>
      <td>String</td>
      <td>是</td>
      <td>未来招聘需求</td>
    </tr>
    <tr>
      <td>urgentMajor</td>
      <td>String</td>
      <td>是</td>
      <td>急需招聘专业</td>
    </tr>
    <tr>
      <td>reportDate</td>
      <td>String</td>
      <td>是</td>
      <td>创建时间</td>
    </tr>
    <tr>
      <td>collegeId</td>
      <td>String</td>
      <td>是</td>
      <td>学院编号</td>
    </tr>
    <tr>
      <td>desc</td>
      <td>String</td>
      <td>否</td>
      <td>描述</td>
    </tr>
  </tbody>
</table>
返回值:

返回一个消息，表示添加成功或失败。

6. 导出周报
URL: http://120.55.14.62:8081/weeklyReport/getWeeklyReportAllNoLimit

Method: POST

请求参数:

参数名	类型	必填	描述
collegeId	String	是	学院编号
返回值:

返回一个可下载的 Excel 文件，包含所有周报信息。

7. 删除周报
URL: http://120.55.14.62:8081/weeklyReport/deleteWeeklyReport

Method: POST

请求参数:

<table>
  <thead>
    <tr>
      <th>参数名</th>
      <th>类型</th>
      <th>必填</th>
      <th>描述</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>collegeId</td>
      <td>String</td>
      <td>是</td>
      <td>学院编号</td>
    </tr>
  </tbody>
</table>
返回值:

返回一个消息，表示删除成功或失败。

8. 更新周报
URL: http://120.55.14.62:8081/weeklyReport/updateWeeklyReport

Method: POST

请求参数:

一个包含以下字段的 JSON 对象：

<table>
  <thead>
    <tr>
      <th>参数名</th>
      <th>类型</th>
      <th>必填</th>
      <th>描述</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>reportId</td>
      <td>Number</td>
      <td>是</td>
      <td>报告编号</td>
    </tr>
    <tr>
      <td>collegeId</td>
      <td>String</td>
      <td>是</td>
      <td>学院编号
返回值:

返回一个消息，表示更新成功或失败。
