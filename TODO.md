# TODO LIST
> 记录开发过程中临时遇到的问题、代办  #template注释：考虑制成模板 
* mapper文件中`queryTotal`查询总数需增加查询条件#template
* 控制台出现如下WARN，貌似是没有配置证书，连接url后追加&useSSL=false，暂时添加了dev配置，其他根据环境配置
 url: jdbc:mysql://47.106.213.3:3306/xinrong?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false   
`Wed Aug 08 16:20:45 CST 2018 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6
.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using 
SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide
 truststore for server certificate verification.`
 `翻译：不推荐服务器身份验证，不需要建立SSL连接。根据MySQL 5.5.45 +，+，+ 5.6.26 5.7.6要求SSL连接必须建立明确的选项默认情况下如果不设置。符合现有的应用程序不使用SSL
 的verifyservercertificate属性设置为“false”。你需要显式禁用SSL设置usessl = false，或设置usessl =真实提供服务器证书验证信任库`
* 日期input框添加属性 `autocomplete="off"` ，以免自动完成提示影响用户选择#template
* 客户和车辆 下拉框提数，权限RequiresPermissions添加
* ~~做`新增`操作时，搜索栏默认赋值了~~ 使用reset方法#template
* bill 修改；导入；导出涉及到数据关联的需调整
