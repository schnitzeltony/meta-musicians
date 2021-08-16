SUMMARY = "Synthesizer plug-in (previously released as Vember Audio Surge)"
HOMEPAGE = "https://surge-synthesizer.github.io/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=79ee739fc097e8ad5582e1d177746365"

DEPENDS += " \
    lv2-ttl-generator \
    cairo \
    xcb-util-cursor \
    xcb-util-keysyms \
    libxkbcommon \
    libsndfile1 \
"

inherit cmake python3native features_check lv2-turtle-helper pack_audio_plugins

REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI = " \
    gitsm://github.com/surge-synthesizer/surge.git;branch=main \
    file://0001-arm-native.cmake-adjust-to-oe.patch \
    file://0002-package-vst3.sh-Do-not-try-to-strip-antive.patch \
    file://0003-Do-not-generate-manifest-it-won-t-work-cross.patch \
    file://0004-emit-vector-piggy-adjust-python-python3.patch \
    file://0005-Upgrade-Catch-2-4845.patch \
"
SRCREV = "91069f8d0c0269e962fa3b5f932b4511aa07e451"
S = "${WORKDIR}/git"
PV = "1.9.0"

EXTRA_OECMAKE:append:arm = " -DARM_NATIVE=native"
EXTRA_OECMAKE:append:aarch64 = " -DARM_NATIVE=native"

LV2_TTL_GENERATOR = "${STAGING_BINDIR}/lv2-ttl-generator"

do_ttl_sed() {
    sed -i 's:LV2_PLUGIN_INFO_FILE:${LV2_PLUGIN_INFO_FILE}:g' ${S}/CMakeLists.txt
}

do_install() {
    install -d ${D}${datadir}/surge
    cp -r ${S}/resources/data/* ${D}${datadir}/surge/

    install -d ${D}${bindir}
    install -m 755 ${B}/surge-headless ${D}${bindir}

    install -d ${D}${libdir}/lv2
    cp -r ${B}/surge_products/Surge.lv2 ${D}${libdir}/lv2/

    install -d ${D}${libdir}/vst3
    for lib in `find ${B}/surge_products/Surge.vst3 -name Surge.so`; do
        install $lib ${D}${libdir}/vst3
    done
}

PACKAGES =+ "${PN}-standalone"
FILES:${PN}-standalone = "${bindir}"

RDEPENDS:${PN}-standalone = "${PN}"
RDEPENDS:${PN_LV2} = "${PN}"
RDEPENDS:${PN_VST3} = "${PN}"

