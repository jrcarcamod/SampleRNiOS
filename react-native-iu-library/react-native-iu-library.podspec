require 'json'
package_json = JSON.parse(File.read('package.json'))

Pod::Spec.new do |s|
  s.name         = "react-native-iu-library"
  s.version        = package_json["version"]
  s.summary        = package_json["description"]
  s.homepage       = "https://www.flowsense.com.br"
  s.authors      = { "Vinay" => "vinay@imaginationunwired.com" }
  s.source         = { :http => 'file:' + __dir__ + '/ios' }
  s.platform     = :ios, "12.0"
  s.source_files   = 'ios/*.{h,m}'
  s.public_header_files = 'ios/**/*.h'
  s.dependency 'React',  '>= 0.13.0', '< 1.0.0'
  s.ios.vendored_frameworks = 'ios/DigitalReefSDK.xcframework'
  s.xcconfig = { 'OTHER_LDFLAGS' => '-framework DigitalReefSDK'}
  s.ios.deployment_target = '12.0'
end
