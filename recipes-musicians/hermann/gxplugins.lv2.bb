SUMMARY = "A set of extra lv2 plugins from the guitarix project"
HOMEPAGE = "https://github.com/brummer10/GxPlugins.lv2"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "gitsm://github.com/brummer10/GxPlugins.lv2.git;branch=master;protocol=https"
SRCREV = "fd110089ea9cb675df62662af89f70701757fd8a"
S = "${WORKDIR}/git"
PV = "0.9"

inherit pkgconfig features_check

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS += " \
    cairo \
    virtual/libx11 \
    lv2 \
"

do_compile() {
    export GUI_LDFLAGS="${LDFLAGS}"
    oe_runmake SSE_CFLAGS= STRIP=echo 
}

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} INSTALL_DIR=${libdir}/lv2 install
}


FILES:${PN} += "${libdir}/lv2"
