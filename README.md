# videoweb
spring bppt+mybaties,使用了redies对可能频繁读取的数据库信息进行预先redis储存，使用kafaka对离线消息进行储存，对websocekt进行用户之间的通讯。
以下是接口文档：
# 注意，必须在请求头中添加token，否则非登录注册请求会被拦截。几乎需要使用userId需要都不必填写，后端会从token中解析出token


## 1.接口描述：获取当前登录获取用户信息。

请求URL：/ChangeInfo/getUserInfoById

请求方式：POST

请求参数：无，需要在请求头中添加token

响应参数:
<table><thead><tr><th>参数名</th><th>类型</th><th>描述</th></tr></thead><tbody><tr><td>userId</td><td>int</td><td>用户ID</td></tr><tr><td>email</td><td>String</td><td>用户邮箱</td></tr><tr><td>upName</td><td>String</td><td>用户名</td></tr><tr><td>headAddress</td><td>String</td><td>头像地址</td></tr><tr><td>brief</td><td>String</td><td>用户简介</td></tr></tbody></table>
  
  
  
## 2.getUserInfoByIdT接口
接口描述：根据用户ID获取用户信息。

请求URL：/ChangeInfo/getUserInfoByIdT

请求方式：POST

请求参数：<table><thead><tr><th>参数名</th><th>类型</th><th>是否必须</th><th>描述</th></tr></thead><tbody><tr><td>userId</td><td>int</td><td>是</td><td>用户Id</td></tr></tbody></table>

响应参数：<table><thead><tr><th>参数名</th><th>类型</th><th>描述</th></tr></thead><tbody><tr><td>userId</td><td>int</td><td>用户ID</td></tr><tr><td>email</td><td>String</td><td>用户邮箱</td></tr><tr><td>upName</td><td>String</td><td>用户名</td></tr><tr><td>headAddress</td><td>String</td><td>头像地址</td></tr><tr><td>brief</td><td>String</td><td>用户简介</td></tr></tbody></table>
  
    
## 3.updateUserInfo接口
接口描述：更新用户信息。

请求URL：/ChangeInfo/updateUserInfo

请求方式：POST


请求参数：
<table><thead><tr><th>参数名</th><th>类型</th><th>描述</th></tr></thead><tbody><td>upName</td><td>String</td><td>用户名</td></tr><tr><td>headAddress</td><td>String</td><td>头像地址</td></tr><tr><td>brief</td><td>String</td><td>用户简介</td></tr></tbody></table>

响应参数<table><thead><tr><th>参数名</th><th>类型</th><th>描述</th></tr></thead><tbody><tr><td>无</td><td>String</td><td>完成情况</td></tr>

  
  
## 4.insertDynamic接口
接口描述：插入用户动态。

请求URL：/ChangeInfo/insertDynamic

请求方式：POST

请求参数：<table><thead><tr><th>参数名</th><th>类型</th><th>是否必须</th><th>描述</th></tr></thead><tbody><tr><td>dynamicData</td><td>String</td><td>是</td><td>动态信息</td></tr></tbody></table>



响应参数:String类型，更新结果

## 5.deleteDynamic接口
接口描述：删除用户动态。

请求URL：/ChangeInfo/deleteDynamic

请求方式：POST

请求参数：<table><thead><tr><th>参数名</th><th>类型</th><th>是否必须</th><th>描述</th></tr></thead><tbody><tr><td>id</td><td>int</td><td>是</td><td>动态id</td></tr></tbody></table>


响应参数

## 6.insertVideodata接口
接口描述：上传视频。

请求URL：/ChangeInfo/insertVideodata

请求方式：POST

请求参数：
<table>
<thead>
<tr><th>参数名</th><th>类型</th><th>是否必须</th><th>描述</th></tr>
<thead>
<tbody>
<tr><td>videoFile</td><td>MultipartFile</td><td>是</td><td>视频文件</td></tr>
<tr><td>videoImageFile</td><td>MultipartFile</td><td>是</td><td>视频画面</td></tr>
<tr><td>videoTitle</td><td>String</td><td>是</td><td>视频标题</td></tr>
<tr><td>videoBrief</td><td>String</td><td>是</td><td>视频简介</td></tr>
<tr><td>videoTab</td><td>String</td><td>是</td><td>投稿分区</td></tr>
</tbody>
</table>


响应参数：Srting，是否成功

## 7.insertComment接口
接口描述：插入视频评论。

请求URL：/ChangeInfo/insertComment

请求方式：POST

请求参数：<table><thead><tr><th>参数名</th><th>类型</th><th>是否必须</th><th>描述</th></tr></thead><tbody><tr><td>commentData</td><td>String</td><td>是</td><td>评论内容</td></tr>
<tr><td>videoId</td><td>int</td><td>是</td><td>视频Id</td></tr>
</tbody></table>

响应参数：响应参数：Srting，是否成功


## 8.insertThumb接口
接口描述：向某个视频点赞记录。

请求URL：/ChangeInfo/insertThumb

请求方式：POST

请求参数：
<table><thead><tr><th>参数名</th><th>类型</th><th>是否必须</th><th>描述</th></tr></thead><tbody><tr><td>videoId</td><td>int</td><td>是</td><td>视频id</td></tr></tbody></table>

响应参数:String,是否成功


## 9.checkThumb接口
接口描述：检查用户是否已点赞。

请求URL：/ChangeInfo/checkThumb

请求方式：POST

请求参数：
<table><thead><tr><th>参数名</th><th>类型</th><th>是否必须</th><th>描述</th></tr></thead><tbody><tr><td>videoId</td><td>int</td><td>是</td><td>视频id</td></tr></tbody></table>

响应参数Boolean：true or false;

InfoController接口
获取用户粉丝数
请求URL：

## 1.POST /Info/getFans
请求参数：

<table>
<thead>
<tr><th>参数名</th><th>必选</th><th>类型</th><th>描述</th></tr>
</thead>
<tbody>
<tr><td>users</td><td>是</td><td>int</td><td>指定用户</td></tr>
</tbody>
</table>

响应:
<table>
<thead>
<tr><th>参数名</th><th>类型</th><th>描述</th></tr>
</thead>
<tbody>
<tr><td>count</td><td>int</td><td>用户粉丝数</td></tr>
</tbody>
</table>

## 2.获取用户动态数
请求URL：POST /Info/getDynamic  
请求参数：无

响应：
<table>
<thead>
<tr><th>参数名</th><th>类型</th><th>描述</th></tr>
</thead>
<tbody>
<tr><td>count</td><td>int</td><td>当前用户动态</td></tr>
</tbody>
</table>


## 3.获取用户收藏数
请求URL：

POST /Info/getThumb  
请求参数：
<table>
<thead>
<tr><th>参数名</th><th>必选</th><th>类型</th><th>描述</th></tr>
</thead>
<tbody>
<tr><td>page</td><td>否</td><td>int</td><td>页数</td></tr>
</tbody>
</table>

响应参数：

<table>
<thead>
<tr><th>参数名</th><th>类型</th><th>描述</th></tr>
</thead>
<tbody>
<tr><td>count</td><td>int</td><td>当前用户收藏</td></tr>
</tbody>
</table>

## 4.获取用户粉丝列表
请求URL：

POST /Info/getFansList

请求参数：
<table>
<thead>
<tr><th>参数名</th><th>必选</th><th>类型</th><th>描述</th></tr>
</thead>
<tbody>
<tr><td>page</td><td>否</td><td>int</td><td>页数</td></tr>
</tbody>
</table>
响应参数：

<table>
<thead>
<tr><th>参数名</th><th>类型</th><th>描述</th></tr>
</thead>
<tbody>
<tr><td>up_name	</td><td>string</td><td>用户昵称</td></tr>
<tr><td>head_address	</td><td>string</td><td>用户头像地址</td></tr>
</tbody>
</table>


## 5.获取用户动态列表
请求URL：

POST /Info/getDynamicList
请求参数：
<table>
<thead>
<tr><th>参数名</th><th>必选</th><th>类型</th><th>描述</th></tr>
</thead>
<tbody>
<tr><td>page</td><td>否</td><td>int</td><td>页数</td></tr>
</tbody>
</table>
响应参数：
<table>
<thead>
<tr><th>参数名</th><th>类型</th><th>描述</th></tr>
</thead>
<tbody>
<tr><td>dynamic_data</td><td>string</td><td>用户动态内容</td></tr>
<tr><td>dynamic_time	</td><td>string</td><td>用户动态发布时间</td></tr>
</tbody>
</table>


## 6.获取用户点赞视频列表
请求URL：

POST /Info/getThumbList
请求参数：
<table>
<thead>
<tr><th>参数名</th><th>必选</th><th>类型</th><th>描述</th></tr>
</thead>
<tbody>
<tr><td>page</td><td>否</td><td>int</td><td>页数</td></tr>
</tbody>
</table>
响应参数：
<table>
<thead>
<tr><th>参数名</th><th>类型</th><th>描述</th></tr>
</thead>
<tbody>
<tr><td>video_id</td><td>int</td><td>视频id</td></tr>
<tr><td>user_id		</td><td>int</td><td>用户id</td></tr>
<tr><td>video_title		</td><td>string</td><td>视频标题</td></tr>
<tr><td>video_url		</td><td>string</td><td>视频地址</td></tr>
<tr><td>video_cover		</td><td>string</td><td>视频封面地址</td></tr>
<tr><td>video_desc		</td><td>string</td><td>视频描述</td></tr>
<tr><td>video_tab		</td><td>string</td><td>视频标签</td></tr>
<tr><td>video_time		</td><td>string</td><td>视频发布时间</td></tr>
<tr><td>thumbs		</td><td>int</td><td>点赞数</td></tr>
<tr><td>plays		</td><td>int</td><td>播放数</td></tr>
<tr><td>comments		</td><td>int</td><td>评论数</td></tr>
</tbody>
</table>


## 7.获取用户首页视频列表
请求URL：

POST /Info/getVideoList
请求参数：

<table>
<thead>
<tr><th>参数名</th><th>必选</th><th>类型</th><th>描述</th></tr>
</thead>
<tbody>
<tr><td>page</td><td>否</td><td>int</td><td>页数</td></tr>
</tbody>
</table>
响应参数：

<table>
<thead>
<tr><th>参数名</th><th>类型</th><th>描述</th></tr>
</thead>
<tbody>
<tr><td>video_id</td><td>int</td><td>视频id</td></tr>
<tr><td>user_id		</td><td>int</td><td>用户id</td></tr>
<tr><td>video_title		</td><td>string</td><td>视频标题</td></tr>
<tr><td>video_url		</td><td>string</td><td>视频地址</td></tr>
<tr><td>video_cover		</td><td>string</td><td>视频封面地址</td></tr>
<tr><td>video_desc		</td><td>string</td><td>视频描述</td></tr>
<tr><td>video_tab		</td><td>string</td><td>视频标签</td></tr>
<tr><td>video_time		</td><td>string</td><td>视频发布时间</td></tr>
<tr><td>thumbs		</td><td>int</td><td>点赞数</td></tr>
<tr><td>plays		</td><td>int</td><td>播放数</td></tr>
<tr><td>comments		</td><td>int</td><td>评论数</td></tr>
</tbody>
</table>

## 8.获取前12最热页面数：
POST /Info/getHotVideoList
请求参数：无


响应参数：

<table>
<thead>
<tr><th>参数名</th><th>类型</th><th>描述</th></tr>
</thead>
<tbody>
<tr><td>video_id</td><td>int</td><td>视频id</td></tr>
<tr><td>user_id		</td><td>int</td><td>用户id</td></tr>
<tr><td>video_title		</td><td>string</td><td>视频标题</td></tr>
<tr><td>video_url		</td><td>string</td><td>视频地址</td></tr>
<tr><td>video_cover		</td><td>string</td><td>视频封面地址</td></tr>
<tr><td>video_desc		</td><td>string</td><td>视频描述</td></tr>
<tr><td>video_tab		</td><td>string</td><td>视频标签</td></tr>
<tr><td>video_time		</td><td>string</td><td>视频发布时间</td></tr>
<tr><td>thumbs		</td><td>int</td><td>点赞数</td></tr>
<tr><td>plays		</td><td>int</td><td>播放数</td></tr>
<tr><td>comments		</td><td>int</td><td>评论数</td></tr>
</tbody>
</table>

## 9.获取指定标签的视频
请求URL：

POST /Info/getVideoList
请求参数：

<table>
<thead>
<tr><th>参数名</th><th>必选</th><th>类型</th><th>描述</th></tr>
</thead>
<tbody>
<tr><td>page</td><td>否</td><td>int</td><td>页数</td></tr>
</tbody>
</table>
响应参数：

<table>
<thead>
<tr><th>参数名</th><th>类型</th><th>描述</th></tr>
</thead>
<tbody>
<tr><td>video_id</td><td>int</td><td>视频id</td></tr>
<tr><td>user_id		</td><td>int</td><td>用户id</td></tr>
<tr><td>video_title		</td><td>string</td><td>视频标题</td></tr>
<tr><td>video_url		</td><td>string</td><td>视频地址</td></tr>
<tr><td>video_cover		</td><td>string</td><td>视频封面地址</td></tr>
<tr><td>video_desc		</td><td>string</td><td>视频描述</td></tr>
<tr><td>video_tab		</td><td>string</td><td>视频标签</td></tr>
<tr><td>video_time		</td><td>string</td><td>视频发布时间</td></tr>
<tr><td>thumbs		</td><td>int</td><td>点赞数</td></tr>
<tr><td>plays		</td><td>int</td><td>播放数</td></tr>
<tr><td>comments		</td><td>int</td><td>评论数</td></tr>
</tbody>
</table>

## 根据视频名字模糊搜索
请求URL：

POST /Info/getSearchVideoList
请求参数：

<table>
<thead>
<tr><th>参数名</th><th>必选</th><th>类型</th><th>描述</th></tr>
</thead>
<tbody>
<tr><td>page</td><td>否</td><td>int</td><td>页数</td></tr>
</tbody>
</table>
响应参数：

<table>
<thead>
<tr><th>参数名</th><th>类型</th><th>描述</th></tr>
</thead>
<tbody>
<tr><td>video_id</td><td>int</td><td>视频id</td></tr>
<tr><td>user_id		</td><td>int</td><td>用户id</td></tr>
<tr><td>video_title		</td><td>string</td><td>视频标题</td></tr>
<tr><td>video_url		</td><td>string</td><td>视频地址</td></tr>
<tr><td>video_cover		</td><td>string</td><td>视频封面地址</td></tr>
<tr><td>video_desc		</td><td>string</td><td>视频描述</td></tr>
<tr><td>video_tab		</td><td>string</td><td>视频标签</td></tr>
<tr><td>video_time		</td><td>string</td><td>视频发布时间</td></tr>
<tr><td>thumbs		</td><td>int</td><td>点赞数</td></tr>
<tr><td>plays		</td><td>int</td><td>播放数</td></tr>
<tr><td>comments		</td><td>int</td><td>评论数</td></tr>
</tbody>
</table>

## 获取评论
请求URL：

POST /Info/selectComment

请求参数：

<table>
<thead>
<tr><th>参数名</th><th>必选</th><th>类型</th><th>描述</th></tr>
</thead>
<tbody>
<tr><td>page</td><td>否</td><td>int</td><td>页数</td></tr>
<tr><td>videoId</td><td>是</td><td>int</td><td>视频id</td></tr>
</tbody>
</table>

响应参数：

<table>
<thead>
<tr><th>参数名</th><th>类型</th><th>描述</th></tr>
</thead>
<tbody>
<tr><td>video_id</td><td>int</td><td>视频id</td></tr>
<tr><td>comment_data		</td><td>String</td><td>评论内容</td></tr>
<tr><td>comment_time</td><td>String</td><td>评论时间</td></tr>
</tbody>
</table>

---

# users
## 1.注册
请求URL：

POST /users/registerUser

请求参数：

<table>
<thead>
<tr><th>参数名</th><th>必选</th><th>类型</th><th>描述</th></tr>
</thead>
<tbody>
<tr><td>email</td><td>是</td><td>String</td><td>邮箱</td></tr>
<tr><td>password</td><td>是</td><td>String</td><td>密码</td></tr>
</tbody>
</table>

响应参数：

<table>
<thead>
<tr><th>类型</th><th>描述</th></tr>
</thead>
<tbody>
<tr><td>String</td><td>是否注册成功</td></tr>
</tbody>
</table>

## 2..登录
请求URL：

POST /users/checkUserExist

请求参数：

<table>
<thead>
<tr><th>参数名</th><th>必选</th><th>类型</th><th>描述</th></tr>
</thead>
<tbody>
<tr><td>email</td><td>是</td><td>String</td><td>邮箱</td></tr>
<tr><td>password</td><td>是</td><td>String</td><td>密码</td></tr>
</tbody>
</table>

响应参数：

<table>
<thead>
<tr><th>类型</th><th>描述</th></tr>
</thead>
<tbody>
<tr><td>String</td><td>是否登录成功</td></tr>
</tbody>
</table>


