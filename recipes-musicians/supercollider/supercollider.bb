SUMMARY = "Programming language for audio synthesis and algorithmic composition"
HOMEPAGE = "http://supercollider.github.io/"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = " \
    gitsm://github.com/supercollider/supercollider.git \
    file://0001-Fix-build-with-Qt-5.15.patch \
    file://0002-Fix-boost-1.73.0-support-4983.patch \
"
SRCREV = "e341b4957c304823faca063448792358ce62b077"
PV = "3.11.0"
S = "${WORKDIR}/git/"

inherit cmake_qt5 features_check mime mime-xdg

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS += " \
    qttools-native qttools \
    qtbase \
    qtwebengine \
    qtsvg \
    fftw \
    jack \
    libsndfile1 \
    alsa-lib \
    libxt \
"

SIMD_OPTIONS ??= " \
    -DSSE=OFF \
    -DSSE2=OFF \
"

EXTRA_OECMAKE = "\
    -DCMAKE_BUILD_TYPE="Release" \
    -DLIB_SUFFIX=${@d.getVar('baselib').replace('lib', '')} \
    -DBUILD_TESTING=OFF \
    -DENABLE_TESTSUITE=OFF \
    -DNATIVE=OFF \
    ${SIMD_OPTIONS} \
    -DSC_EL=OFF \
"

PACKAGES =+ "${PN}-gedit-plugin"

FILES_${PN} += " \
    ${datadir}/gtksourceview-3.0 \
    ${datadir}/mime \
    ${datadir}/SuperCollider \
    ${libdir}/SuperCollider/plugins/*.so \
"
INSANE_SKIP_${PN} = "useless-rpaths"

FILES_${PN}-gedit-plugin = " \
    ${libdir}/gedit \
"
